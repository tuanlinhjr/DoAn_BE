package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.DTO.ChiTietMuonTraDTO;
import com.example.doantotnghiep.models.ChiTietMuonTra;
import com.example.doantotnghiep.models.ChiTietSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChiTietMuonTraRepository extends JpaRepository<ChiTietMuonTra, Long> {
    List<ChiTietMuonTra> findByMuonTra_MaMuonTra(Long maMuonTra);

    @Query("SELECT COUNT(ct) FROM ChiTietMuonTra ct WHERE ct.muonTra.maMuonTra = :maMuonTra AND ct.tinhTrangTra = 'Đang Mượn'")
    Long countCTMuonTra(@Param("maMuonTra") Long maMuonTra);

    @Query("SELECT sum(ct.tienPhat) from ChiTietMuonTra ct where ct.muonTra.maMuonTra = :maMuonTra")
    Long sumTienPhat(@Param("maMuonTra") Long maMuonTra);

    @Query("select cts.sach.maSach, s.tenSach, count(cts.sach.maSach)" +
            "from ChiTietMuonTra ct join ChiTietSach cts " +
            "on ct.chiTietSach.maChiTietSach = cts.maChiTietSach " +
            "join Sach s on s.maSach = cts.sach.maSach " +
            "group by cts.sach.maSach, s.tenSach " +
            "order by count(cts.sach.maSach) desc ")
    List<Object[]> top5SachMuon();
    @Query("SELECT ctmt from ChiTietMuonTra ctmt where ctmt.ghiChu = 'Hỏng'")
    List<ChiTietMuonTra> getSachHong();
}
