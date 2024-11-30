package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.ViTri;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViTriDTO {
    private Long maViTri;
    private String tenViTri;

    public static ViTriDTO fromEntity(ViTri viTri){
        return new ViTriDTO(viTri.getMaViTri(), viTri.getTenViTri());
    }
}
