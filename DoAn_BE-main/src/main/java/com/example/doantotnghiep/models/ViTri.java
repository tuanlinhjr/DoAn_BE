package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vitri")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViTri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maViTri;
    @Column(length = 255, nullable = true)
    private String tenViTri;

//    @OneToMany(mappedBy = "viTri", cascade = CascadeType.ALL)
//    private List<ChiTietSach> chiTietSaches;
}
