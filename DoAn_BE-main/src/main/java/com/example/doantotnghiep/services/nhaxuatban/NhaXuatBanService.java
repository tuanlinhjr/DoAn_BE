package com.example.doantotnghiep.services.nhaxuatban;


import com.example.doantotnghiep.DTO.NhaCungCapDTO;
import com.example.doantotnghiep.DTO.NhaXuatBanDTO;

import com.example.doantotnghiep.models.NhaXuatBan;

import com.example.doantotnghiep.repositories.INhaXuatBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhaXuatBanService implements INhaXuatBanService{
    @Autowired
    private INhaXuatBanRepository nhaXuatBanRepository;
    @Override
    public NhaXuatBanDTO addNXB(NhaXuatBanDTO nhaXuatBanDTO) {
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.setTenNxb(nhaXuatBanDTO.getTenNxb());
        nhaXuatBan.setDiaChi(nhaXuatBanDTO.getDiaChi());
        nhaXuatBan.setSoDienThoai(nhaXuatBanDTO.getSoDienThoai());
        return NhaXuatBanDTO.fromEntity(nhaXuatBanRepository.save(nhaXuatBan));
    }

    @Override
    public NhaXuatBanDTO updateNXB(Long maNXB, NhaXuatBanDTO nXBDetails) {
        NhaXuatBan nhaXuatBan = nhaXuatBanRepository.findById(maNXB)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà xuất bản với mã là: " + maNXB));
        nhaXuatBan.setTenNxb(nXBDetails.getTenNxb());
        nhaXuatBan.setDiaChi(nXBDetails.getDiaChi());
        nhaXuatBan.setSoDienThoai(nXBDetails.getSoDienThoai());
        return NhaXuatBanDTO.fromEntity(nhaXuatBanRepository.save(nhaXuatBan));
    }

    @Override
    public void xoaNXB(Long maNXB) {

    }

    @Override
    public Optional<NhaXuatBanDTO> finById(Long maNXB) {
        return nhaXuatBanRepository.findById(maNXB).stream()
                .findFirst().map(NhaXuatBanDTO::fromEntity);
    }

    @Override
    public List<NhaXuatBanDTO> getAll() {
        return nhaXuatBanRepository.findAll()
                .stream().map(NhaXuatBanDTO::fromEntity).collect(Collectors.toList());
    }
}
