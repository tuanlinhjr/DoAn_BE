package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViTriRepository extends JpaRepository<ViTri, Long> {
}
