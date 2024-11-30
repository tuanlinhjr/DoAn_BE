package com.example.doantotnghiep.services.phongban;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.PhongBanDTO;

import java.util.List;
import java.util.Optional;

public interface IPhongBanService {
    PhongBanDTO addPhongBan(PhongBanDTO phongBanDTO);
    PhongBanDTO updatePhongBan(Long maPhongBan, PhongBanDTO phongBanDetails);

    void xoaPhongBan(Long maPhongBan);

    Optional<PhongBanDTO> finById(Long maPhongBan);

    List<PhongBanDTO> getAll();
}
