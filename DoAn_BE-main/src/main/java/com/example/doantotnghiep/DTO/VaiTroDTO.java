package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.VaiTro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaiTroDTO {
    private Long maVaiTro;
    private String tenVaiTro;
    private String donViCongTac;

    public static VaiTroDTO fromEntity(VaiTro vaiTro){
        return new VaiTroDTO(vaiTro.getMaVaiTro(), vaiTro.getTenVaiTro(), vaiTro.getDonViCongTac());
    }
}
