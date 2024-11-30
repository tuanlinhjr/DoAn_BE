package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITheLoaiRepository extends JpaRepository<TheLoai, Long> {
    boolean existsByTenTheLoai(String tenTheLoai);

}
