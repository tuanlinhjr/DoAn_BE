package com.example.doantotnghiep.services.vaitro;

import com.example.doantotnghiep.DTO.VaiTroDTO;
import com.example.doantotnghiep.models.VaiTro;
import com.example.doantotnghiep.repositories.IVaiTroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaiTroService implements IVaiTroService{
    @Autowired
    private IVaiTroRepository vaiTroRepository;
    @Override
    public VaiTroDTO addVaiTro(VaiTroDTO vaiTroDTO) {
        VaiTro vaiTro = new VaiTro();
        vaiTro.setTenVaiTro(vaiTroDTO.getTenVaiTro());
        vaiTro.setDonViCongTac(vaiTro.getDonViCongTac());
        return VaiTroDTO.fromEntity(vaiTroRepository.save(vaiTro));
    }

    @Override
    public VaiTroDTO updateVaiTro(Long maVaiTro, VaiTroDTO vaiTroDetails) {
        VaiTro vaiTro = vaiTroRepository.findById(maVaiTro)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò với mã là: " + maVaiTro));
        vaiTro.setTenVaiTro(vaiTroDetails.getTenVaiTro());
        vaiTro.setDonViCongTac(vaiTro.getDonViCongTac());
        return VaiTroDTO.fromEntity(vaiTroRepository.save(vaiTro));
    }

    @Override
    public void xoaVaiTro(Long maVaiTro) {

    }

    @Override
    public Optional<VaiTroDTO> finById(Long maVaiTro) {
        return vaiTroRepository.findById(maVaiTro).stream()
                .findFirst().map(VaiTroDTO::fromEntity);
    }

    @Override
    public List<VaiTroDTO> getAll() {
        return vaiTroRepository.findAll()
                .stream().map(VaiTroDTO::fromEntity).collect(Collectors.toList());
    }
}
