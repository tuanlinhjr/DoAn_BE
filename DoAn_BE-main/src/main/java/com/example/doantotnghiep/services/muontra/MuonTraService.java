package com.example.doantotnghiep.services.muontra;

import com.example.doantotnghiep.DTO.ChiTietMuonTraDTO;
import com.example.doantotnghiep.DTO.MuonTraDTO;
import com.example.doantotnghiep.DTO.MuonTraVaChiTiet;
import com.example.doantotnghiep.models.*;
import com.example.doantotnghiep.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.*;

@Service
public class MuonTraService implements IMuonTraService{
    @Autowired
    private IMuonTraRepository muonTraRepository;

    @Autowired
    private IChiTietMuonTraRepository chiTietMuonTraRepository;

    @Autowired
    private INhanVienRepository nhanVienRepository;
    @Autowired
    private IDocGiaRepository docGiaRepository;

    @Autowired
    private IChiTietSachRepository chiTietSachRepository;

    @Autowired
    private IChiTietMuonTraService chiTietMuonTraService;
    @Override
    public MuonTraDTO addMuonTra(MuonTraDTO muonTraDTO) {
        try{
            LocalDate ngayMuon = LocalDate.now();

            LocalDate ngayTraDuKien = ngayMuon.plusDays(7);
            MuonTra muonTra = new MuonTra();
            muonTra.setNgayMuon(ngayMuon);
            muonTra.setNgayTraDuKien(ngayTraDuKien);
            muonTra.setNgayTraThucTe(muonTraDTO.getNgayTraThucTe());
            muonTra.setTongTienPhat(muonTraDTO.getTongTienPhat());
            muonTra.setTinhTrang("Đang Mượn");
            NhanVien nhanVien = nhanVienRepository.findById(muonTraDTO.getMaNV())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên có mã là: " + muonTraDTO.getMaNV()));
            muonTra.setNhanVien(nhanVien);
            DocGia docGia = docGiaRepository.findById(muonTraDTO.getMaDocGia())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy độc giả có mã là: " + muonTraDTO.getMaDocGia()));
            muonTra.setDocGia(docGia);
            // Trả về phiếu mượn đã tạo
            return MuonTraDTO.fromEntity(muonTraRepository.save(muonTra));
        }catch (Exception e){
            throw new RuntimeException("Đã xảy ra lỗi khi thêm phiếu mượn", e);
        }
    }

    @Override
    public MuonTraDTO updateMuonTra(Long maMuonTra) {
        MuonTra muonTra = muonTraRepository.findById(maMuonTra)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy phiếu mượn trả có mã là: " + maMuonTra));

        // Lấy danh sách các chi tiết mượn trả liên quan đến phiếu mượn trả cụ thể
        List<ChiTietMuonTra> chiTietMuonTraList = chiTietMuonTraRepository.findByMuonTra_MaMuonTra(maMuonTra);

        // Kiểm tra xem tất cả sách đã được trả hay chưa
        boolean allBooksReturned = chiTietMuonTraList.stream()
                .allMatch(chiTietMuonTra -> chiTietMuonTra.getChiTietSach().getTinhTrangSach().equals("Chưa Mượn"));

        if (allBooksReturned) {
            LocalDate ngayTraThucTe = LocalDate.now();
            // Nếu tất cả sách đã được trả, cập nhật trạng thái và ngày trả thực tế
            if (ngayTraThucTe.isAfter(muonTra.getNgayTraDuKien())) {
                muonTra.setTinhTrang("Quá Hạn");
                muonTra.setTongTienPhat(100000.0);
            } else {
                muonTra.setTinhTrang("Đã Trả");
            }
            muonTra.setNgayTraThucTe(ngayTraThucTe);
            return MuonTraDTO.fromEntity(muonTraRepository.save(muonTra));
        } else {
            throw new RuntimeException("Không thể cập nhật phiếu mượn trả vì có ít nhất một sách chưa được trả.");
        }

    }

    @Override
    public void xoaMuonTra(Long maMuonTra) {

    }

    @Override
    public Optional<MuonTraDTO> findById(Long maMuonTra) {
        return Optional.empty();
    }

    @Override
    public List<MuonTra> getAll() {
        return muonTraRepository.findAll();
    }

    @Override
    public List<MuonTra> getMuonByMaDocGia(Long maDocGia) {
        return muonTraRepository.findMuonTraByDocGia_MaDocGia(maDocGia);
    }

    @Override
    public List<MuonTra> getTraByMaDocGia(Long maDocGia) {
        return muonTraRepository.findTraByDocGia_MaDocGia(maDocGia);
    }

    @Override
    public MuonTraDTO yeuCauGiaHan(Long maMuonTra) {
        MuonTra muonTra = muonTraRepository.findById(maMuonTra)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy phiếu mượn trả có mã là: " + maMuonTra));
        muonTra.setTinhTrangGiaHan("Yêu cầu gia hạn");
        return MuonTraDTO.fromEntity(muonTraRepository.save(muonTra));
    }

    @Override
    public MuonTraDTO huyGiaHan(Long maMuonTra) {
        MuonTra muonTra = muonTraRepository.findById(maMuonTra)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy phiếu mượn trả có mã là: " + maMuonTra));
        muonTra.setTinhTrangGiaHan(null);
        return MuonTraDTO.fromEntity(muonTraRepository.save(muonTra));
    }

    @Override
    public MuonTraDTO xacNhanGiaHan(Long maMuonTra) {
        MuonTra muonTra = muonTraRepository.findById(maMuonTra)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy phiếu mượn trả có mã là: " + maMuonTra));
        LocalDate ngayTraDuKien = muonTra.getNgayTraDuKien();

        LocalDate giaHan = ngayTraDuKien.plusDays(7);
        muonTra.setNgayTraDuKien(giaHan);
        muonTra.setTinhTrangGiaHan("Gia hạn thành công");
        return MuonTraDTO.fromEntity(muonTraRepository.save(muonTra));
    }

    @Override
    public List<MuonTra> danhSachGiaHan() {
        return muonTraRepository.danhSachGiaHan();
    }

    public Map<Integer, Long> countMuonSachGroupByMonth(LocalDate startDate, LocalDate endDate) {
        List<Object[]> results = muonTraRepository.countMuonSachGroupByMonth(startDate, endDate);
        Map<Integer, Long> counts = new HashMap<>();
        for (Object[] result : results) {
            Integer month = (Integer) result[0];
            Long count = (Long) result[1];
            counts.put(month, count);
        }
        return counts;
    }

    public Map<Integer, Long> countTraSachGroupByMonth(LocalDate startDate, LocalDate endDate) {
        List<Object[]> results = muonTraRepository.countTraSachGroupByMonth(startDate, endDate);
        Map<Integer, Long> counts = new HashMap<>();
        for (Object[] result : results) {
            Integer month = (Integer) result[0];
            Long count = (Long) result[1];
            counts.put(month, count);
        }
        return counts;
    }

    public List<Map<String, Object>> getTopUsersByBorrowCount() {
        List<Object[]> results = muonTraRepository.top5DocGia();
        List<Map<String, Object>> topUsers = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> userData = new HashMap<>();
            userData.put("maDocGia", result[0]);
            userData.put("tenDocGia", result[1]);
            userData.put("soLuong", result[2]);
            topUsers.add(userData);
        }
        return topUsers;
    }




}
