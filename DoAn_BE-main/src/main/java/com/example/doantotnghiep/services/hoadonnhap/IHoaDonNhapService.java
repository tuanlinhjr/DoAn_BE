package com.example.doantotnghiep.services.hoadonnhap;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.HoaDonNhapDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.HoaDonNhap;

import java.util.List;

public interface IHoaDonNhapService {

    HoaDonNhapDTO addHoaDonNhap(HoaDonNhapDTO hoaDonNhapDTO) throws Exception;
    List<HoaDonNhap> getAll();


}
