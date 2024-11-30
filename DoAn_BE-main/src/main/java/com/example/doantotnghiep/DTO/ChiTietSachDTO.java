package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.ChiTietSach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSachDTO {
    private Long maChiTietSach;
    private String moTa;
    private String tinhTrangSach;
    private Long maSach;


    public static ChiTietSachDTO fromEntity(ChiTietSach chiTietSach){
        return new ChiTietSachDTO(chiTietSach.getMaChiTietSach(), chiTietSach.getMoTa(), chiTietSach.getTinhTrangSach(),
                chiTietSach.getSach().getMaSach());
    }
}
