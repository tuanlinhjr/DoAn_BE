package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, Long> {
    boolean existsByMaNV(Long maNV);

    // Phương thức kiểm tra sự tồn tại của email
    boolean existsByEmail(String email);

    boolean existsBySoDienThoai(String soDienThoai);


    Optional<NhanVien> findByUserNameAndPassWord(String userName, String passWord);

    Optional<NhanVien> findByUserName(String userName);
}
