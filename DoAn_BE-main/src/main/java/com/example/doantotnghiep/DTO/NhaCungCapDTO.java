package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.NhaCungCap;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCapDTO {
    private Long MaNcc;
    private String tenNcc;
    private String diaChi;
    private String soDienThoai;

    public static NhaCungCapDTO fromEntity(NhaCungCap nhaCungCap){
        return new NhaCungCapDTO(nhaCungCap.getMaNcc(), nhaCungCap.getTenNcc(), nhaCungCap.getDiaChi(), nhaCungCap.getSoDienThoai());
    }
}
