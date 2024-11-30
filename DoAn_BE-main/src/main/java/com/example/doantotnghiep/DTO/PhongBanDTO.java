package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.PhongBan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongBanDTO {
    private Long maPhongBan;
    private String tenPhongBan;

    public static PhongBanDTO fromEntity(PhongBan phongBan){
        return new PhongBanDTO(phongBan.getMaPhongBan(), phongBan.getTenPhongBan());
    }
}
