package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.NhaXuatBan;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaXuatBanDTO {
    private Long MaNxb;
    private String tenNxb;
    private String diaChi;
    private String soDienThoai;

    public static NhaXuatBanDTO fromEntity(NhaXuatBan nhaXuatBan){
        return new NhaXuatBanDTO(nhaXuatBan.getMaNxb(), nhaXuatBan.getTenNxb(), nhaXuatBan.getDiaChi(), nhaXuatBan.getSoDienThoai());
    }
}
