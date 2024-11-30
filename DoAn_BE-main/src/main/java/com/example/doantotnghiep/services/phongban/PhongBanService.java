package com.example.doantotnghiep.services.phongban;

import com.example.doantotnghiep.DTO.PhongBanDTO;
import com.example.doantotnghiep.DTO.TheLoaiDTO;
import com.example.doantotnghiep.models.PhongBan;
import com.example.doantotnghiep.models.TheLoai;
import com.example.doantotnghiep.repositories.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhongBanService implements IPhongBanService{
    @Autowired
    private IPhongBanRepository phongBanRepository;

    @Override
    public PhongBanDTO addPhongBan(PhongBanDTO phongBanDTO) {
        PhongBan phongBan = new PhongBan();
        phongBan.setTenPhongBan(phongBanDTO.getTenPhongBan());
        return PhongBanDTO.fromEntity(phongBanRepository.save(phongBan));
    }

    @Override
    public PhongBanDTO updatePhongBan(Long maPhongBan, PhongBanDTO phongBanDetails) {
        PhongBan phongBan = phongBanRepository.findById(maPhongBan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban với mã là: " + maPhongBan));
        phongBan.setTenPhongBan(phongBanDetails.getTenPhongBan());
        return PhongBanDTO.fromEntity(phongBanRepository.save(phongBan));
    }

    @Override
    public void xoaPhongBan(Long maPhongBan) {

    }

    @Override
    public Optional<PhongBanDTO> finById(Long maPhongBan) {
        return phongBanRepository.findById(maPhongBan).stream()
                .findFirst().map(PhongBanDTO::fromEntity);
    }

    @Override
    public List<PhongBanDTO> getAll() {
        return phongBanRepository.findAll()
                .stream().map(PhongBanDTO::fromEntity).collect(Collectors.toList());
    }
}
