package com.example.doantotnghiep.services.vitri;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.ViTriDTO;
import com.example.doantotnghiep.models.NgonNgu;
import com.example.doantotnghiep.models.ViTri;
import com.example.doantotnghiep.repositories.IViTriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViTriService implements IViTriService{
    @Autowired
    private IViTriRepository viTriRepository;
    @Override
    public ViTriDTO addViTri(ViTriDTO viTriDTO) {
        ViTri viTri = new ViTri();
        viTri.setTenViTri(viTriDTO.getTenViTri());
        return ViTriDTO.fromEntity(viTriRepository.save(viTri));
    }

    @Override
    public ViTriDTO updateViTri(Long maViTri, ViTriDTO viTriDetails) {
        ViTri viTri = viTriRepository.findById(maViTri)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy vị trí với mã là: " + maViTri));
        viTri.setTenViTri(viTriDetails.getTenViTri());
        return ViTriDTO.fromEntity(viTriRepository.save(viTri));
    }

    @Override
    public void xoaViTri(Long maViTri) {

    }

    @Override
    public Optional<ViTriDTO> finById(Long maViTri) {
        return viTriRepository.findById(maViTri).stream()
                .findFirst().map(ViTriDTO::fromEntity);
    }

    @Override
    public List<ViTriDTO> getAll() {
        return viTriRepository.findAll()
                .stream().map(ViTriDTO::fromEntity).collect(Collectors.toList());
    }
}
