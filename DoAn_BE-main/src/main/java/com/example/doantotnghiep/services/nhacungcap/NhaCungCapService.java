package com.example.doantotnghiep.services.nhacungcap;


import com.example.doantotnghiep.DTO.NhaCungCapDTO;

import com.example.doantotnghiep.models.NhaCungCap;

import com.example.doantotnghiep.repositories.INhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhaCungCapService implements INhaCungCapService{
    @Autowired
    private INhaCungCapRepository nhaCungCapRepository;

    @Override
    public NhaCungCapDTO addNCC(NhaCungCapDTO nhaCungCapDTO) {
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setTenNcc(nhaCungCapDTO.getTenNcc());
        nhaCungCap.setDiaChi(nhaCungCapDTO.getDiaChi());
        nhaCungCap.setSoDienThoai(nhaCungCapDTO.getSoDienThoai());
        return NhaCungCapDTO.fromEntity(nhaCungCapRepository.save(nhaCungCap));
    }

    @Override
    public NhaCungCapDTO updateNCC(Long maNCC, NhaCungCapDTO nCCDetails) {
        NhaCungCap nhaCungCap = nhaCungCapRepository.findById(maNCC)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà cung cấp với mã là: " + maNCC));
        nhaCungCap.setTenNcc(nCCDetails.getTenNcc());
        nhaCungCap.setDiaChi(nCCDetails.getDiaChi());
        nhaCungCap.setSoDienThoai(nCCDetails.getSoDienThoai());
        return NhaCungCapDTO.fromEntity(nhaCungCapRepository.save(nhaCungCap));
    }

    @Override
    public void xoaNCC(Long maNCC) {

    }

    @Override
    public Optional<NhaCungCapDTO> finById(Long maNCC) {
        return nhaCungCapRepository.findById(maNCC).stream()
                .findFirst().map(NhaCungCapDTO::fromEntity);
    }

    @Override
    public List<NhaCungCapDTO> getAll() {
        return nhaCungCapRepository.findAll()
                .stream().map(NhaCungCapDTO::fromEntity).collect(Collectors.toList());
    }
}
