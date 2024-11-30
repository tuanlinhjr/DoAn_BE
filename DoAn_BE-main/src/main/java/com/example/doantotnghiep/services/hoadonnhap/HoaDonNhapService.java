package com.example.doantotnghiep.services.hoadonnhap;

import com.example.doantotnghiep.DTO.*;
import com.example.doantotnghiep.models.*;
import com.example.doantotnghiep.repositories.*;
import com.example.doantotnghiep.services.chitiethdn.ChiTietHDNService;
import com.example.doantotnghiep.services.chitietsach.ChiTietSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class HoaDonNhapService implements IHoaDonNhapService {
    @Autowired
    private IHoaDonNhapRepository hoaDonNhapRepository;

    @Autowired
    private INhanVienRepository nhanVienRepository;
    @Autowired
    private INhaCungCapRepository nhaCungCapRepository;

    @Autowired
    private IChiTietHDNRepository chiTietHDNRepository;
    @Autowired
    private ISachRepository sachRepository;


    @Override
    public HoaDonNhapDTO addHoaDonNhap(HoaDonNhapDTO hoaDonNhapDTO) throws Exception {
        HoaDonNhap hoaDonNhap = new HoaDonNhap();
        hoaDonNhap.setNgayNhap(new Date());
        hoaDonNhap.setTrangThai("Đã Nhập");
        hoaDonNhap.setTongTien(hoaDonNhapDTO.getTongTien());
        NhanVien nhanVien = nhanVienRepository.findById(hoaDonNhapDTO.getMaNV())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên có mã là: " + hoaDonNhapDTO.getMaNV()));
        hoaDonNhap.setNhanVien(nhanVien);
        NhaCungCap nhaCungCap = nhaCungCapRepository.findById(hoaDonNhapDTO.getMaNcc())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà cung cấp có mã là: " + hoaDonNhapDTO.getMaNcc()));
        hoaDonNhap.setNhaCungCap(nhaCungCap);


        HoaDonNhap savedHoaDonNhap = hoaDonNhapRepository.save(hoaDonNhap);

        return HoaDonNhapDTO.fromEntity(savedHoaDonNhap);
    }

    @Override
    public List<HoaDonNhap> getAll() {
        return hoaDonNhapRepository.findAll();
    }



}
