package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.TheLoai;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheLoaiDTO {
    private Long maTheLoai;
    private String tenTheLoai;

    public static TheLoaiDTO fromEntity(TheLoai theLoai){
        return new TheLoaiDTO(theLoai.getMaTheLoai(), theLoai.getTenTheLoai());
    }
}
