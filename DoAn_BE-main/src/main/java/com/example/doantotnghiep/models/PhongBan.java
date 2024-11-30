package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "phongban")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maPhongBan;
    @Column(length = 255, nullable = true)
    private String tenPhongBan;

//    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
//    private List<NhanVien> nhanViens;
}
