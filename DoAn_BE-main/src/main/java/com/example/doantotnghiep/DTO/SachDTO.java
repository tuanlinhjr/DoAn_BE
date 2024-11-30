package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.Sach;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class SachDTO {
    private Long maSach;
    private String tenSach;
    private MultipartFile anhBia;
    private String tinhTrang;
    private Double giaBia;
    private Long namXuatBan;
    private Long maNxb;
    private Long maNgonNgu;
    private Long maTacGia;
    private Long maTheLoai;

    public SachDTO(Long maSach, String tenSach, String tinhTrang, Double giaBia, Long namXuatBan, Long maNxb, Long maNgonNgu, Long maTacGia, Long maTheLoai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tinhTrang = tinhTrang;
        this.giaBia = giaBia;
        this.namXuatBan = namXuatBan;
        this.maNxb = maNxb;
        this.maNgonNgu = maNgonNgu;
        this.maTacGia = maTacGia;
        this.maTheLoai = maTheLoai;

    }

    public static SachDTO fromEntity(Sach sach){
        return new SachDTO(sach.getMaSach(), sach.getTenSach(), sach.getTinhTrang(), sach.getGiaBia(),
                sach.getNamXuatBan(), sach.getNhaXuatBan().getMaNxb(), sach.getNgonNgu().getMaNgonNgu(), sach.getTacGia().getMaTacGia(),
                sach.getTheLoai().getMaTheLoai());
    }
}
