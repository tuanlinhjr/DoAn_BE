package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.ChiTietHDN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHDNDTO {
    private Long maChiTietHDN;
    private Long soLuong;
    private Long maHDN;
    private Long maSach;

    public static ChiTietHDNDTO fromEntity(ChiTietHDN chiTietHDN){
        return new ChiTietHDNDTO(chiTietHDN.getMaChiTietHDN(), chiTietHDN.getSoLuong(), chiTietHDN.getHoaDonNhap().getMaHDN(), chiTietHDN.getSach().getMaSach());
    }
}
