package com.example.doantotnghiep.services.muontra;

import com.example.doantotnghiep.DTO.ChiTietMuonTraDTO;
import com.example.doantotnghiep.models.ChiTietMuonTra;
import com.example.doantotnghiep.models.ChiTietSach;
import com.example.doantotnghiep.models.MuonTra;
import com.example.doantotnghiep.repositories.IChiTietMuonTraRepository;
import com.example.doantotnghiep.repositories.IChiTietSachRepository;
import com.example.doantotnghiep.repositories.IMuonTraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChiTietMuonTraService implements IChiTietMuonTraService{
    @Autowired
    private IChiTietMuonTraRepository chiTietMuonTraRepository;
    @Autowired
    private IChiTietSachRepository chiTietSachRepository;
    @Autowired
    private IMuonTraRepository muonTraRepository;

    @Override
    public ChiTietMuonTraDTO addChiTiet(ChiTietMuonTraDTO chiTietMuonTraDTO) throws Exception {
        try{
            ChiTietMuonTra chiTietMuonTra = new ChiTietMuonTra();
            chiTietMuonTra.setTienPhat(chiTietMuonTraDTO.getTienPhat());
            chiTietMuonTra.setGhiChu(chiTietMuonTraDTO.getGhiChu());
            chiTietMuonTra.setTinhTrangTra("Đang Mượn");
            ChiTietSach chiTietSach = chiTietSachRepository.findById(chiTietMuonTraDTO.getMaChiTietSach())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết sách có mã là: " + chiTietMuonTraDTO.getMaChiTietSach()));
            chiTietMuonTra.setChiTietSach(chiTietSach);
            MuonTra muonTra = muonTraRepository.findById(chiTietMuonTraDTO.getMaMuonTra())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy mã mượn trả có mã là: " + chiTietMuonTraDTO.getMaMuonTra()));
            chiTietMuonTra.setMuonTra(muonTra);
            return ChiTietMuonTraDTO.fromEntity(chiTietMuonTraRepository.save(chiTietMuonTra));
        }catch (Exception e){
            throw new RuntimeException("Đã xảy ra lỗi khi thêm chi tiết phiếu mượn", e);

        }
    }
    @Override
    public ChiTietMuonTraDTO updateChiTiet(Long maCTMuonTra, ChiTietMuonTraDTO chiTietMuonTraDTO) {
        ChiTietMuonTra chiTietMuonTra = chiTietMuonTraRepository.findById(maCTMuonTra)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết có mã là: " + maCTMuonTra));

        // Lấy mã chi tiết sách từ chi tiết mượn trả
        Long maChiTietSach = chiTietMuonTra.getChiTietSach().getMaChiTietSach();

        // Kiểm tra xem mã chi tiết sách có tồn tại không
        if (maChiTietSach == null) {
            throw new IllegalArgumentException("Mã chi tiết sách không được trống!");
        }
        chiTietMuonTra.setTinhTrangTra("Đã Trả");
        chiTietMuonTra.setGhiChu(chiTietMuonTraDTO.getGhiChu());

        if(chiTietMuonTraDTO.getGhiChu() == null){
            chiTietMuonTra.setTienPhat(0.0);
        }else{
            chiTietMuonTra.setTienPhat(chiTietMuonTraDTO.getTienPhat());
        }
        ChiTietSach chiTietSach = chiTietSachRepository.findById(maChiTietSach)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách có mã là: " + maChiTietSach));

        chiTietSach.setTinhTrangSach("Chưa Mượn");
        chiTietMuonTra.setChiTietSach(chiTietSach);

        return ChiTietMuonTraDTO.fromEntity(chiTietMuonTraRepository.save(chiTietMuonTra));
    }


    @Override
    public void xoaChiTiet(Long maCTMuonTra) {

    }

    @Override
    public Optional<ChiTietMuonTraDTO> findById(Long maCTMuonTra) {
        return Optional.empty();
    }

    @Override
    public List<ChiTietMuonTra> getAll() {
        return chiTietMuonTraRepository.findAll();
    }

    @Override
    public List<ChiTietMuonTra> findByMuonTra(Long maMuonTra) {
        return chiTietMuonTraRepository.findByMuonTra_MaMuonTra(maMuonTra);
    }

    @Override
    public Long countCTMuonTra(Long maMuonTra) {
        return chiTietMuonTraRepository.countCTMuonTra(maMuonTra);
    }

    @Override
    public Long sumTienPhat(Long maMuonTra) {
        return chiTietMuonTraRepository.sumTienPhat(maMuonTra);
    }

    @Override
    public List<ChiTietMuonTra> getSachHong() {
        return chiTietMuonTraRepository.getSachHong();
    }

    public List<Map<String, Object>> getTop5BorrowedBooks() {
        List<Object[]> results = chiTietMuonTraRepository.top5SachMuon();
        List<Map<String, Object>> topBooks = new ArrayList<>();
        int count = 0;
        for (Object[] result : results) {
            if (count >= 5) break; // Ensure only top 5
            Map<String, Object> bookData = new HashMap<>();
            bookData.put("maSach", result[0]);
            bookData.put("tenSach", result[1]);
            bookData.put("soLuong", result[2]);
            topBooks.add(bookData);
            count++;
        }
        return topBooks;
    }


}
