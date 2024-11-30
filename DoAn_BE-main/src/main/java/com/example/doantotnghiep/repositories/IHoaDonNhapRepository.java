package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.HoaDonNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHoaDonNhapRepository extends JpaRepository<HoaDonNhap, Long> {
}
