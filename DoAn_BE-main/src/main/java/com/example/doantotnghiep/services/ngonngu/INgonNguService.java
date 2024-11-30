package com.example.doantotnghiep.services.ngonngu;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import java.util.List;
import java.util.Optional;

public interface INgonNguService {
    NgonNguDTO addNgonNgu(NgonNguDTO ngonNguDTO);
    NgonNguDTO updateNgonNgu(Long maNgonNgu, NgonNguDTO ngonNguDetails);

    void xoaNgonNgu(Long maNgonNgu);

    Optional<NgonNguDTO> finById(Long maNgonNgu);

    List<NgonNguDTO> getAll();
}
