package com.example.doantotnghiep.services.sach;

import com.example.doantotnghiep.DTO.SachDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.ChiTietSach;
import com.example.doantotnghiep.models.Sach;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface ISachService {
    SachDTO addSach(SachDTO sachDTO);

    boolean addSach(SachDTO sachDTO, HttpServletRequest request);

    boolean updateSach(Long maSach, SachDTO sachDetails, HttpServletRequest request);
    void deleteSach(Long maSach);

    Optional<Sach> findById(Long maSach);

    List<Sach> getAll();

    List<Sach> findSachByMaTL(Long maTheLoai);


}
