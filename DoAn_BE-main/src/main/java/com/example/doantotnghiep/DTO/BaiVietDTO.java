package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.BaiViet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiVietDTO {
    private Long maBaiViet;
    private String tieuDe;
    private String noiDung;
    private String anhBaiViet;
    private Long maNV;

    public static BaiVietDTO fromEntity(BaiViet baiViet){
        return new BaiVietDTO(baiViet.getMaBaiViet(), baiViet.getTieuDe(), baiViet.getNoiDung(), baiViet.getAnhBaiViet(), baiViet.getNhanVien().getMaNV());
    }
}
