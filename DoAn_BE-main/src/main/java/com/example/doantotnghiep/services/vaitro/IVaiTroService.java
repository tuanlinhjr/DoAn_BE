package com.example.doantotnghiep.services.vaitro;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.VaiTroDTO;

import java.util.List;
import java.util.Optional;

public interface IVaiTroService {
    VaiTroDTO addVaiTro(VaiTroDTO vaiTroDTO);
    VaiTroDTO updateVaiTro(Long maVaiTro, VaiTroDTO vaiTroDetails);

    void xoaVaiTro(Long maVaiTro);

    Optional<VaiTroDTO> finById(Long maVaiTro);

    List<VaiTroDTO> getAll();
}
