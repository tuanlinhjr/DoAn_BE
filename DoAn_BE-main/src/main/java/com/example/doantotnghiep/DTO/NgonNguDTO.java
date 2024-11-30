package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.NgonNgu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NgonNguDTO {
    public Long maNgonNgu;
    public String tenNgonNgu;

    public static NgonNguDTO fromEntity(NgonNgu ngonNgu){
        return new NgonNguDTO(ngonNgu.getMaNgonNgu(), ngonNgu.getTenNgonNgu());
    }
}
