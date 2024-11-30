package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.ChiTietSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChiTietSachRepository extends JpaRepository<ChiTietSach, Long> {
    @Query("SELECT cts FROM ChiTietSach cts WHERE cts.sach.maSach = :maSach AND cts.tinhTrangSach = 'Chưa Mượn'")
    List<ChiTietSach> findBySach_MaSach(Long maSach);

    @Query("SELECT count(*) from ChiTietSach cts where cts.tinhTrangSach = 'Đang Mượn' or cts.tinhTrangSach = 'Chưa Mượn'")
    Long tongSoSach();

    @Query("SELECT count(*) from ChiTietSach cts where cts.tinhTrangSach = 'Đang Mượn'")
    Long soSachDangMuon();

    @Query("SELECT count(*) from ChiTietSach cts where cts.tinhTrangSach = 'Chưa Mượn'")
    Long soSachCoSan();
    @Query("SELECT count(*) from ChiTietSach cts where cts.tinhTrangSach = 'Hỏng'")
    Long soSachHong();
}
