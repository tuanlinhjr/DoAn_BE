package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.NhanVien;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDTO {
    private Long maNV;
    private String tenNV;
    private String gioiTinh;
    private String soDienThoai;
    private Long namSinh;
    private String email;
    private String userName;
    private String passWord;
    private Long trangThaiHoatDong;
    private Long maPhongBan;
    private Long maVaiTro;

    public static NhanVienDTO fromEntity(NhanVien nhanVien){
        return new NhanVienDTO(nhanVien.getMaNV(), nhanVien.getTenNV(),nhanVien.getGioiTinh(), nhanVien.getSoDienThoai(), nhanVien.getNamSinh(),
                nhanVien.getEmail(), nhanVien.getUserName(), nhanVien.getPassWord(), nhanVien.getTrangThaiHoatDong(), nhanVien.getPhongBan().getMaPhongBan(),
                nhanVien.getVaiTro().getMaVaiTro());
    }
}
