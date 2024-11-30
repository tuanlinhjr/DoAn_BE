package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.models.NgonNgu;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.models.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISachRepository extends JpaRepository<Sach, Long> {
    List<Sach> findByTheLoai(TheLoai theLoai);
    List<Sach> findByNgonNgu(NgonNgu ngonNgu);
//    @Query(value = "select * from Sach join NhaXuatBan on Sach.maSach = NhaXuatBan.maNxb " +
//            "join TacGia on Sach.maTacGia = TacGia.maTacGia " +
//            "join TheLoai on Sach.maTheLoai = TheLoai.maTheLoai " +
//            "join NgonNgu on Sach.maNgonNgu = NgonNgu.maNgonNgu", nativeQuery = true)
//    Optional<Sach> findSach();
    // Phương thức kiểm tra sự tồn tại của email
    boolean existsByTenSach(String tenSach);

    List<Sach> findByTheLoai_MaTheLoai(Long maTheLoai);


}
