package com.example.doantotnghiep.models;

import com.example.doantotnghiep.DoAnTotNghiepApplication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chitietmuontra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietMuonTra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maCTMuonTra;
    @Column(nullable = true)
    private Double tienPhat;
    @Column(length = 255, nullable = true)
    private String ghiChu;

    private String tinhTrangTra;

    @ManyToOne
    @JoinColumn(name = "maMuonTra")
    private MuonTra muonTra;

    @ManyToOne
    @JoinColumn(name = "maChiTietSach")
    private ChiTietSach chiTietSach;
}
