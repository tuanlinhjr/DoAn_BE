package com.example.doantotnghiep.services.tacgia;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.TacGiaDTO;

import java.util.List;
import java.util.Optional;

public interface ITacGiaService {
    TacGiaDTO addTacGia(TacGiaDTO tacGiaDTO);
    TacGiaDTO updateTacGia(Long maTacGia, TacGiaDTO tacGiaDetails);

    void xoaTacGia(Long maTacGia);

    Optional<TacGiaDTO> finById(Long maTacGia);

    List<TacGiaDTO> getAll();
}
