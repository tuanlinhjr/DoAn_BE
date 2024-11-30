package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chitiethdn")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHDN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maChiTietHDN;
    private Long soLuong;

    @ManyToOne
    @JoinColumn(name = "maHDN")
    private HoaDonNhap hoaDonNhap;

    @ManyToOne
    @JoinColumn(name = "maSach")
    private Sach sach;
}
