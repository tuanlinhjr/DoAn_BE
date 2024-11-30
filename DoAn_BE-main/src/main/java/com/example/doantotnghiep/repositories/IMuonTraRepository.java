package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.MuonTra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMuonTraRepository extends JpaRepository<MuonTra, Long> {

    @Query("select month(mt.ngayMuon) as month,count(mt.maMuonTra) " +
            "from MuonTra mt " +
            "where mt.ngayMuon between :startDate and :endDate " +
            "group by month(mt.ngayMuon)")
    List<Object[]> countMuonSachGroupByMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("select month(mt.ngayTraThucTe) as month,count(mt.maMuonTra) " +
            "from MuonTra mt " +
            "where mt.ngayTraThucTe between :startDate and :endDate " +
            "group by month(mt.ngayTraThucTe)")
    List<Object[]> countTraSachGroupByMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT mt.docGia.maDocGia, dg.tenDocGia, count(mt.maMuonTra)" +
            "from MuonTra mt join DocGia dg " +
            "on mt.docGia.maDocGia = dg.maDocGia " +
            "group by mt.docGia.maDocGia, dg.tenDocGia " +
            "order by count(mt.maMuonTra) desc ")
    List<Object[]> top5DocGia();
    @Query("SELECT mt FROM MuonTra mt WHERE mt.docGia.maDocGia = :maDocGia AND mt.tinhTrang = 'Đang Mượn'")
    List<MuonTra> findMuonTraByDocGia_MaDocGia(Long maDocGia);
    @Query("SELECT mt FROM MuonTra mt WHERE mt.docGia.maDocGia = :maDocGia AND mt.tinhTrang = 'Đã Trả'")
    List<MuonTra> findTraByDocGia_MaDocGia(Long maDocGia);

    @Query("SELECT mt FROM MuonTra mt WHERE mt.tinhTrangGiaHan = 'Yêu cầu gia hạn'")
    List<MuonTra> danhSachGiaHan();


}
