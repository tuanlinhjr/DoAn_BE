package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.YeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IYeuThichRepository extends JpaRepository<YeuThich, Long> {
}
