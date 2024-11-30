package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.ChiTietMuonTra;
import com.example.doantotnghiep.models.MuonTra;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuonTraDTO {
    private Long maMuonTra;
    private LocalDate ngayMuon;
    private LocalDate ngayTraDuKien;
    private LocalDate ngayTraThucTe;
    private Double tongTienPhat;
    private String tinhTrang;
    private Long maDocGia;
    private Long maNV;
    private String tinhTrangGiaHan;


    public static MuonTraDTO fromEntity(MuonTra muonTra){
        return new MuonTraDTO(muonTra.getMaMuonTra(), muonTra.getNgayMuon(), muonTra.getNgayTraDuKien(), muonTra.getNgayTraThucTe()
                    , muonTra.getTongTienPhat(), muonTra.getTinhTrang(), muonTra.getDocGia().getMaDocGia(), muonTra.getNhanVien().getMaNV(), muonTra.getTinhTrangGiaHan());
    }
}
