package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "hoadonNhap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maHDN;
    private Date ngayNhap;
    private Double tongTien;
    @Column(length = 255, nullable = true)
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maNcc")
    private NhaCungCap nhaCungCap;

//    @OneToMany(mappedBy = "hoaDonNhap", cascade = CascadeType.ALL)
//    private List<ChiTietHDN> chiTietHDNS;
}
