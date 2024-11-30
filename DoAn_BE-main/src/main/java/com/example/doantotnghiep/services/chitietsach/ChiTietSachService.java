package com.example.doantotnghiep.services.chitietsach;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.DTO.ChiTietSachDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.models.*;
import com.example.doantotnghiep.repositories.IChiTietSachRepository;
import com.example.doantotnghiep.repositories.ISachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSachService implements IChiTietSachService{
    @Autowired
    private IChiTietSachRepository chiTietSachRepository;

    @Autowired
    private ISachRepository sachRepository;

    @Override
    public ChiTietSachDTO addChiTietSach(ChiTietSachDTO chiTietSachDTO) throws Exception {
        ChiTietSach chiTietSach = new ChiTietSach();
        chiTietSach.setMoTa("Mới");
        chiTietSach.setTinhTrangSach("Chưa Mượn");
        Sach sach = sachRepository.findById(chiTietSachDTO.getMaSach())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách có mã là: " + chiTietSachDTO.getMaSach()));
        chiTietSach.setSach(sach);
        return ChiTietSachDTO.fromEntity( chiTietSachRepository.save(chiTietSach));
//        return null;
    }

    @Override
    public List<ChiTietSach> getAll() {
        return chiTietSachRepository.findAll();
    }

    @Override
    public List<ChiTietSach> findByCTSach(Long maSach) {
        return chiTietSachRepository.findBySach_MaSach(maSach);
    }

    @Override
    public Long tongSoSach(){
        return chiTietSachRepository.tongSoSach();
    }

    @Override
    public Long soSachDangMuon(){
        return chiTietSachRepository.soSachDangMuon();
    }

    @Override
    public Long soSachCoSan(){
        return chiTietSachRepository.soSachCoSan();
    }
    @Override
    public Long soSachHong(){
        return chiTietSachRepository.soSachHong();
    }

    @Override
    public ChiTietSachDTO updateTinhTrang(Long maChiTietSach) {
        ChiTietSach chiTietSach = chiTietSachRepository.findById(maChiTietSach)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết có mã là: " + maChiTietSach));
        chiTietSach.setTinhTrangSach("Hỏng");
        return ChiTietSachDTO.fromEntity(chiTietSachRepository.save(chiTietSach));
    }

}
