package com.example.doantotnghiep.repositories;


import com.example.doantotnghiep.models.NhaXuatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhaXuatBanRepository extends JpaRepository<NhaXuatBan, Long> {
}
