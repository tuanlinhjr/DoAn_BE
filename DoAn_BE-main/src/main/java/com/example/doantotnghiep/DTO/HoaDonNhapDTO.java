package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.HoaDonNhap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonNhapDTO {
    private Long maHDN;
    private Date ngayNhap;
    private Double tongTien;
    private String trangThai;
    private Long MaNV;
    private Long maNcc;


        public static HoaDonNhapDTO fromEntity(HoaDonNhap hoaDonNhap){
        return new HoaDonNhapDTO(hoaDonNhap.getMaHDN(), hoaDonNhap.getNgayNhap(), hoaDonNhap.getTongTien(), hoaDonNhap.getTrangThai()
                , hoaDonNhap.getNhanVien().getMaNV(), hoaDonNhap.getNhaCungCap().getMaNcc());
    }

//    public static HoaDonNhapDTO fromEntity(HoaDonNhap hoaDonNhap, List<ChiTietHDNDTO> chiTietHDNDTOList) {
//        return new HoaDonNhapDTO(
//                hoaDonNhap.getMaHDN(),
//                hoaDonNhap.getNgayNhap(),
//                hoaDonNhap.getTongTien(),
//                hoaDonNhap.getTrangThai(),
//                hoaDonNhap.getNhanVien().getMaNV(),
//                hoaDonNhap.getNhaCungCap().getMaNcc(),
//                chiTietHDNDTOList
//        );
//    }
}
