package com.example.doantotnghiep.services.docgia;

import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhaCungCapDTO;
import com.example.doantotnghiep.models.DocGia;

import java.util.List;
import java.util.Optional;

public interface IDocGiaService {
    DocGiaDTO addDocGia(DocGiaDTO docGiaDTO) throws Exception;
    DocGiaDTO updateDocGia(Long maDocGia, DocGiaDTO docGiaDetails);

    void xoaDocGia(Long maDocGia);

    Optional<DocGiaDTO> finById(Long maDocGia);

    List<DocGia> getAll();

    void importDocGiaFromExcel(String filePath);
}
