package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vaitro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maVaiTro;
    @Column(length = 255, nullable = true)
    private String tenVaiTro;
    @Column(length = 255, nullable = true)
    private String donViCongTac;

//    @OneToMany(mappedBy = "vaiTro", cascade = CascadeType.ALL)
//    private List<NhanVien> nhanViens;

//    @OneToMany(mappedBy = "vaiTro", cascade = CascadeType.ALL)
//    private List<DocGia> docGias;
}
