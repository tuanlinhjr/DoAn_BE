package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "chitietsach")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maChiTietSach;
    @Column(length = 1000, nullable = true)
    private String moTa;
    @Column(length = 255, nullable = true)
    private String tinhTrangSach;

    @ManyToOne
    @JoinColumn(name = "maSach")
    private Sach sach;

    @ManyToOne
    @JoinColumn(name = "maViTri")
    private ViTri viTri;

//    @OneToMany(mappedBy = "chiTietSach", cascade = CascadeType.ALL)
//    private List<ChiTietMuonTra> chiTietMuonTras;
}
