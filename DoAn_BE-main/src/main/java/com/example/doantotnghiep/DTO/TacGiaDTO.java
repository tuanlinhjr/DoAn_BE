package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.TacGia;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacGiaDTO {
    private Long maTacGia;
    private String tenTacGia;
    private Long namSinh;
    private String gioiTinh;

    public static TacGiaDTO fromEntity(TacGia tacGia){
        return new TacGiaDTO(tacGia.getMaTacGia(), tacGia.getTenTacGia(), tacGia.getNamSinh(), tacGia.getGioiTinh());
    }
}
