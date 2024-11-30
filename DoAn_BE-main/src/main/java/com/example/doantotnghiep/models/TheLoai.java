package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theloai")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTheLoai;
    @Column(length = 255, nullable = true)
    private String tenTheLoai;

//    @OneToMany(mappedBy = "theLoai", cascade = CascadeType.ALL)
//    private List<Sach> saches;
}
