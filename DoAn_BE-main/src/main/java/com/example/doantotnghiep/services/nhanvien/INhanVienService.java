package com.example.doantotnghiep.services.nhanvien;

import com.example.doantotnghiep.DTO.ChangePass;
import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.models.NhanVien;

import java.util.List;
import java.util.Optional;

public interface INhanVienService {
    NhanVienDTO addNhanVien(NhanVienDTO nhanVienDTO) throws Exception;
    NhanVienDTO updateNhanVien(Long maNV, NhanVienDTO nVDetails);
    NhanVienDTO updateTTNhanVien(Long maNV, NhanVienDTO nVDetails);

    void xoaNhanVien(Long maNV);

    Optional<NhanVienDTO> findById(Long maNV);

    List<NhanVien> getAll();
    void importNhanVienFromExcel(String filePath);

    boolean changePassword(Long maNV, ChangePass changePass);


}
