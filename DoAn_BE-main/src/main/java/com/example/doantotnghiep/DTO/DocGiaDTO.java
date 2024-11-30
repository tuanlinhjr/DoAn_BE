package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.DocGia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocGiaDTO {
    private Long maDocGia;
    private String tenDocGia;
    private String gioiTinh;
    private String soDienThoai;
    private Long namSinh;
    private String email;
    private String userName;
    private String passWord;
    private Long trangThaiHoatDong;
    private Long maVaiTro;

    public static DocGiaDTO fromEntity(DocGia docGia){
        return new DocGiaDTO(docGia.getMaDocGia(), docGia.getTenDocGia(), docGia.getGioiTinh(), docGia.getSoDienThoai(),
                docGia.getNamSinh(), docGia.getEmail(), docGia.getUserName(), docGia.getPassWord(), docGia.getTrangThaiHoatDong(), docGia.getVaiTro().getMaVaiTro());
    }
}
