package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.TacGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITacGiaRepository extends JpaRepository<TacGia, Long> {
}
