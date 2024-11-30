package com.example.doantotnghiep.services.chitiethdn;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.HoaDonNhapDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.models.ChiTietHDN;

import java.util.List;
import java.util.Optional;

public interface IChiTietHDNService {
    ChiTietHDNDTO addChiTietHDN(ChiTietHDNDTO chiTietHDNDTO) throws Exception;

    List<ChiTietHDN> getAll();
    List<ChiTietHDN> findByCTHDN(Long maHDN);


}
