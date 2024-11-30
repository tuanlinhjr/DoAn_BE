package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "docgia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocGia {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDocGia;
    @Column(length = 255, nullable = true)
    private String tenDocGia;
    @Column(length = 255, nullable = true)
    private String gioiTinh;
    @Column(length = 255, nullable = true)
    private String soDienThoai;
    private Long namSinh;
    @Column(length = 255, nullable = true, unique = true)
    private String email;
    @Column(length = 255, nullable = false, unique = true)
    private String userName;
    @Column(length = 255, nullable = false)
    private String passWord;
    @Column(nullable = true)
    private Long trangThaiHoatDong;

    @ManyToOne
    @JoinColumn(name = "maVaiTro")
    private VaiTro vaiTro;

//    @OneToMany(mappedBy = "docGia", cascade = CascadeType.ALL)
//    private List<YeuThich> yeuThiches;

//    @OneToMany(mappedBy = "docGia", cascade = CascadeType.ALL)
//    private List<MuonTra> muonTras;
}
