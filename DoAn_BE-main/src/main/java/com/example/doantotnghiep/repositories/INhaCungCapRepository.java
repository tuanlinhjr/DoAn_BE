package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhaCungCapRepository extends JpaRepository<NhaCungCap, Long> {
}
