package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.HoaDonNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChiTietHDNRepository extends JpaRepository<ChiTietHDN, Long> {
    List<ChiTietHDN> findByHoaDonNhap_MaHDN(Long maHDN);

    @Query("select sum(cthdn.soLuong) from ChiTietHDN cthdn")
    Long tongSachNhap();

}
