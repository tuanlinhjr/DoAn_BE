package com.example.doantotnghiep.services.nhaxuatban;

import com.example.doantotnghiep.DTO.NhaCungCapDTO;
import com.example.doantotnghiep.DTO.NhaXuatBanDTO;

import java.util.List;
import java.util.Optional;

public interface INhaXuatBanService {
    NhaXuatBanDTO addNXB(NhaXuatBanDTO nhaXuatBanDTO);
    NhaXuatBanDTO updateNXB(Long maNXB, NhaXuatBanDTO nXBDetails);

    void xoaNXB(Long maNXB);

    Optional<NhaXuatBanDTO> finById(Long maNXB);

    List<NhaXuatBanDTO> getAll();
}
