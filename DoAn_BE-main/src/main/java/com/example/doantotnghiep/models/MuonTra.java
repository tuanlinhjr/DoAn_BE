package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "muontra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuonTra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maMuonTra;
    private LocalDate ngayMuon;
    private LocalDate ngayTraDuKien;
    @Column(nullable = true)
    private LocalDate ngayTraThucTe;
    private Double tongTienPhat;
    @Column(length = 255, nullable = true)
    private String tinhTrang;

    private String tinhTrangGiaHan;

    @ManyToOne
    @JoinColumn(name = "maDocGia")
    private DocGia docGia;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

//    @OneToMany(mappedBy = "muonTra", cascade = CascadeType.ALL)
//    private List<ChiTietMuonTra> chiTietMuonTras;


}
