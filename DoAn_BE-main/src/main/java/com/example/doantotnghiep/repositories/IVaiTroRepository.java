package com.example.doantotnghiep.repositories;

import com.example.doantotnghiep.models.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaiTroRepository extends JpaRepository<VaiTro, Long> {
    void deleteByMaVaiTro(Long maVaiTro);
}
