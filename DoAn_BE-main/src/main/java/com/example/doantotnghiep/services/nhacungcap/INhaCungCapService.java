package com.example.doantotnghiep.services.nhacungcap;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.NhaCungCapDTO;

import java.util.List;
import java.util.Optional;

public interface INhaCungCapService {
    NhaCungCapDTO addNCC(NhaCungCapDTO nhaCungCapDTO);
    NhaCungCapDTO updateNCC(Long maNCC, NhaCungCapDTO nCCDetails);

    void xoaNCC(Long maNCC);

    Optional<NhaCungCapDTO> finById(Long maNCC);

    List<NhaCungCapDTO> getAll();
}
