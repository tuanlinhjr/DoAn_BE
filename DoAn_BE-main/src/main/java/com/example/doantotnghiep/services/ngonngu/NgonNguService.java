package com.example.doantotnghiep.services.ngonngu;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.TheLoaiDTO;
import com.example.doantotnghiep.models.NgonNgu;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.models.TheLoai;
import com.example.doantotnghiep.repositories.INgonNguRepository;
import com.example.doantotnghiep.repositories.ISachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NgonNguService implements INgonNguService {
    @Autowired
    private INgonNguRepository ngonNguRepository;

    @Autowired
    private ISachRepository sachRepository;
    @Override
    public NgonNguDTO addNgonNgu(NgonNguDTO ngonNguDTO) {
        NgonNgu ngonNgu = new NgonNgu();
        ngonNgu.setTenNgonNgu(ngonNguDTO.getTenNgonNgu());
        return NgonNguDTO.fromEntity(ngonNguRepository.save(ngonNgu));
    }

    @Override
    public NgonNguDTO updateNgonNgu(Long maNgonNgu, NgonNguDTO ngonNguDetails) {
        NgonNgu ngonNgu = ngonNguRepository.findById(maNgonNgu)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ngôn ngữ với mã là: " + maNgonNgu));
        ngonNgu.setTenNgonNgu(ngonNguDetails.getTenNgonNgu());
        return NgonNguDTO.fromEntity(ngonNguRepository.save(ngonNgu));
    }

    @Override
    public void xoaNgonNgu(Long maNgonNgu) {
        Optional<NgonNgu> optionalNgonNgu = ngonNguRepository.findById(maNgonNgu);
        if (optionalNgonNgu.isPresent()) {
            NgonNgu ngonNgu = optionalNgonNgu.get();
            List<Sach> sachInNgonNgu = sachRepository.findByNgonNgu(ngonNgu);
            if (sachInNgonNgu.isEmpty()) {
                ngonNguRepository.deleteById(maNgonNgu);
            } else {
                throw new RuntimeException("Không thể xóa thể loại này vì có sách có ngôn ngữ này.");
            }
        } else {
            throw new RuntimeException("Không tìm thấy ngôn ngữ với mã là: " + maNgonNgu);
        }
    }

    @Override
    public Optional<NgonNguDTO> finById(Long maNgonNgu) {
        return ngonNguRepository.findById(maNgonNgu).stream()
                .findFirst().map(NgonNguDTO::fromEntity);
    }

    @Override
    public List<NgonNguDTO> getAll() {
        return ngonNguRepository.findAll()
                .stream().map(NgonNguDTO::fromEntity).collect(Collectors.toList());
    }
}
