package com.example.doantotnghiep.services.chitiethdn;


import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.HoaDonNhap;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.repositories.IChiTietHDNRepository;
import com.example.doantotnghiep.repositories.IHoaDonNhapRepository;
import com.example.doantotnghiep.repositories.ISachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietHDNService implements IChiTietHDNService{
    @Autowired
    private IChiTietHDNRepository chiTietHDNRepository;
    @Autowired
    private ISachRepository sachRepository;

    @Autowired
    private IHoaDonNhapRepository hoaDonNhapRepository;

    @Override
    public ChiTietHDNDTO addChiTietHDN(ChiTietHDNDTO chiTietHDNDTO) throws Exception {
        ChiTietHDN chiTietHDN = new ChiTietHDN();
        chiTietHDN.setSoLuong(chiTietHDNDTO.getSoLuong());
        Sach sach = sachRepository.findById(chiTietHDNDTO.getMaSach())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách có mã là: " + chiTietHDNDTO.getMaSach()));
        chiTietHDN.setSach(sach);
        HoaDonNhap hoaDonNhap = hoaDonNhapRepository.findById(chiTietHDNDTO.getMaHDN())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn nhập có mã là: " + chiTietHDNDTO.getMaHDN()));
        chiTietHDN.setHoaDonNhap(hoaDonNhap);
        return ChiTietHDNDTO.fromEntity( chiTietHDNRepository.save(chiTietHDN));
//        return null;
    }

    @Override
    public List<ChiTietHDN> getAll() {
        return chiTietHDNRepository.findAll();
    }
    @Override
    public List<ChiTietHDN> findByCTHDN(Long maHDN) {
        return chiTietHDNRepository.findByHoaDonNhap_MaHDN(maHDN);
    }

    public Long tongSachNhap(){
        return chiTietHDNRepository.tongSachNhap();
    }




}
