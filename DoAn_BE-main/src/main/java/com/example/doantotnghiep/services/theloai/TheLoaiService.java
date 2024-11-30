package com.example.doantotnghiep.services.theloai;

import com.example.doantotnghiep.DTO.TheLoaiDTO;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.models.TheLoai;
import com.example.doantotnghiep.repositories.ISachRepository;
import com.example.doantotnghiep.repositories.ITheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheLoaiService implements ITheLoaiService{
    @Autowired
    private ITheLoaiRepository theLoaiRepository;

    @Autowired
    private ISachRepository sachRepository;
    @Override
    public TheLoaiDTO addTheLoai(TheLoaiDTO theLoaiDTO){
        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(theLoaiDTO.getTenTheLoai());
        return TheLoaiDTO.fromEntity(theLoaiRepository.save(theLoai));
    }

    @Override
    public TheLoaiDTO updateTheLoai(Long maTheLoai, TheLoaiDTO theLoaiDetails) {
        TheLoai theLoai = theLoaiRepository.findById(maTheLoai)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại với mã là: " + maTheLoai));
        theLoai.setTenTheLoai(theLoaiDetails.getTenTheLoai());
        return TheLoaiDTO.fromEntity(theLoaiRepository.save(theLoai));
    }

    @Override
    public void xoaTheLoai(Long maTheLoai) {
        Optional<TheLoai> optionalTheLoai = theLoaiRepository.findById(maTheLoai);
        if (optionalTheLoai.isPresent()) {
            TheLoai theLoai = optionalTheLoai.get();
            List<Sach> sachInTheLoai = sachRepository.findByTheLoai(theLoai);
            if (sachInTheLoai.isEmpty()) {
                theLoaiRepository.deleteById(maTheLoai);
            } else {
                throw new RuntimeException("Không thể xóa thể loại này vì có sách thuộc thể loại này.");
            }
        } else {
            throw new RuntimeException("Không tìm thấy thể loại với mã là: " + maTheLoai);
        }
    }

    @Override
    public Optional<TheLoaiDTO> finById(Long maTheLoai) {
        return theLoaiRepository.findById(maTheLoai).stream()
                .findFirst().map(TheLoaiDTO::fromEntity);
    }

    @Override
    public List<TheLoaiDTO> getAll() {
        return theLoaiRepository.findAll()
                .stream().map(TheLoaiDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public boolean isTenTheLoaiExists(String tenTheLoai) {
        return theLoaiRepository.existsByTenTheLoai(tenTheLoai);
    }




}
