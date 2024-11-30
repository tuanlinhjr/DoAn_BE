package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nhanvien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNV;
    @Column(length = 255, nullable = true)
    private String tenNV;
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

//    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
//    private List<BaiViet> baiviets;

    @ManyToOne
    @JoinColumn(name = "maPhongBan")
    private PhongBan phongBan;

    @ManyToOne
    @JoinColumn(name = "maVaiTro")
    private VaiTro vaiTro;

//    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
//    private List<MuonTra> muonTras;

//    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
//    private List<HoaDonNhap> hoaDonNhaps;
}
