package com.example.doantotnghiep.services.tacgia;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.TacGiaDTO;
import com.example.doantotnghiep.models.NgonNgu;
import com.example.doantotnghiep.models.TacGia;
import com.example.doantotnghiep.repositories.ITacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TacGiaService implements ITacGiaService{
    @Autowired
    private ITacGiaRepository tacGiaRepository;
    @Override
    public TacGiaDTO addTacGia(TacGiaDTO tacGiaDTO) {
        TacGia tacGia = new TacGia();
        tacGia.setTenTacGia(tacGiaDTO.getTenTacGia());
        tacGia.setGioiTinh(tacGiaDTO.getGioiTinh());
        tacGia.setNamSinh(tacGiaDTO.getNamSinh());
        return TacGiaDTO.fromEntity(tacGiaRepository.save(tacGia));
    }

    @Override
    public TacGiaDTO updateTacGia(Long maTacGia, TacGiaDTO tacGiaDetails) {
        TacGia tacGia = tacGiaRepository.findById(maTacGia)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả với mã là: " + maTacGia));
        tacGia.setTenTacGia(tacGiaDetails.getTenTacGia());
        tacGia.setGioiTinh(tacGiaDetails.getGioiTinh());
        tacGia.setNamSinh(tacGiaDetails.getNamSinh());
        return TacGiaDTO.fromEntity(tacGiaRepository.save(tacGia));
    }

    @Override
    public void xoaTacGia(Long maTacGia) {

    }

    @Override
    public Optional<TacGiaDTO> finById(Long maTacGia) {
        return tacGiaRepository.findById(maTacGia).stream()
                .findFirst().map(TacGiaDTO::fromEntity);
    }

    @Override
    public List<TacGiaDTO> getAll() {
        return tacGiaRepository.findAll()
                .stream().map(TacGiaDTO::fromEntity).collect(Collectors.toList());
    }
}
