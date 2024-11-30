package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaiVietRepository extends JpaRepository<BaiViet, Long> {
}
