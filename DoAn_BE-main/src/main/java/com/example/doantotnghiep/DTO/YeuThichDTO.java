package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.YeuThich;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YeuThichDTO {
    private Long maYeuThich;
    private Long maDocGia;
    private Long maSach;

    public static YeuThichDTO fromEntity(YeuThich yeuThich){
        return new YeuThichDTO(yeuThich.getMaYeuThich(), yeuThich.getDocGia().getMaDocGia(), yeuThich.getSach().getMaSach());
    }
}
