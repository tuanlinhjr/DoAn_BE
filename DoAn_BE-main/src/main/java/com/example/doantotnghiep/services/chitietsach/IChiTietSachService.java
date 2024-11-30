package com.example.doantotnghiep.services.chitietsach;

import com.example.doantotnghiep.DTO.ChiTietSachDTO;
import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.models.ChiTietSach;

import java.util.List;

public interface IChiTietSachService {
    ChiTietSachDTO addChiTietSach(ChiTietSachDTO chiTietSachDTO) throws Exception;

    List<ChiTietSach> getAll();
    List<ChiTietSach> findByCTSach(Long maSach);

    Long tongSoSach();

    Long soSachDangMuon();

    Long soSachCoSan();
    Long soSachHong();
    ChiTietSachDTO updateTinhTrang(Long maChiTietSach);
}
