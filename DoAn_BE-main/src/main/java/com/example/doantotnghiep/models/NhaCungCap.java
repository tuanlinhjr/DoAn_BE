package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "nhacungcap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MaNcc;

    @Column(length = 255, nullable = true)
    private String tenNcc;
    @Column(length = 255, nullable = true)
    private String diaChi;
    @Column(length = 255, nullable = true)
    private String soDienThoai;

//    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
//    private List<HoaDonNhap> hoaDonNhaps;
}
