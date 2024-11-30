package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, Long> {
}
