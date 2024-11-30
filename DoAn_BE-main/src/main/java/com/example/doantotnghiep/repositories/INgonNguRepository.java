package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.NgonNgu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INgonNguRepository extends JpaRepository<NgonNgu, Long> {
}
