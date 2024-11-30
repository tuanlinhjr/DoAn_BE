package com.example.doantotnghiep.services.theloai;



import com.example.doantotnghiep.DTO.TheLoaiDTO;

import java.util.List;
import java.util.Optional;

public interface ITheLoaiService {
    TheLoaiDTO addTheLoai(TheLoaiDTO theLoaiDTO);
    TheLoaiDTO updateTheLoai(Long maTheLoai, TheLoaiDTO theLoaiDetails);

    void xoaTheLoai(Long maTheLoai);

    Optional<TheLoaiDTO> finById(Long maTheLoai);

    List<TheLoaiDTO> getAll();
    boolean isTenTheLoaiExists(String tenTheLoai);
}
