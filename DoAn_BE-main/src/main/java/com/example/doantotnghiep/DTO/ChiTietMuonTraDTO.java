package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.ChiTietMuonTra;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietMuonTraDTO {
    private Long maCTMuonTra;

    private Double tienPhat;

    private String ghiChu;
    private Long maMuonTra;
    private Long maChiTietSach;

    private String tinhTrangTra;

    public static ChiTietMuonTraDTO fromEntity(ChiTietMuonTra chiTietMuonTra){
        return new ChiTietMuonTraDTO(chiTietMuonTra.getMaCTMuonTra(), chiTietMuonTra.getTienPhat(), chiTietMuonTra.getGhiChu(),
                chiTietMuonTra.getMuonTra().getMaMuonTra(),chiTietMuonTra.getChiTietSach().getMaChiTietSach(), chiTietMuonTra.getTinhTrangTra());
    }

}
