package com.example.doantotnghiep.services.vitri;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.ViTriDTO;

import java.util.List;
import java.util.Optional;

public interface IViTriService {
    ViTriDTO addViTri(ViTriDTO viTriDTO);
    ViTriDTO updateViTri(Long maViTri, ViTriDTO viTriDetails);

    void xoaViTri(Long maViTri);

    Optional<ViTriDTO> finById(Long maViTri);

    List<ViTriDTO> getAll();
}
