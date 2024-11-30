package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "nhaxuatban")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MaNxb;

    @Column(length = 255, nullable = true)
    private String tenNxb;
    @Column(length = 255, nullable = true)
    private String diaChi;
    @Column(length = 255, nullable = true)
    private String soDienThoai;

//    @OneToMany(mappedBy = "nhaXuatBan", cascade = CascadeType.ALL)
//    private List<Sach> saches;
}
