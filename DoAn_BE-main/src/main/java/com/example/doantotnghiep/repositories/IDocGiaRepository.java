package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.DocGia;
import com.example.doantotnghiep.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDocGiaRepository extends JpaRepository<DocGia, Long> {
    boolean existsByMaDocGia(Long maDocGia);

    // Phương thức kiểm tra sự tồn tại của email
    boolean existsByEmail(String email);

    boolean existsBySoDienThoai(String soDienThoai);
    Optional<DocGia> findByUserNameAndPassWord(String userName, String passWord);

    Optional<DocGia> findByUserName(String userName);
}
