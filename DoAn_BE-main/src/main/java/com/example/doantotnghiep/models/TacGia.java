package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tacgia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTacGia;
    @Column(length = 255, nullable = true)
    private String tenTacGia;
    private Long namSinh;
    @Column(length = 255, nullable = true)
    private String gioiTinh;
    @Column(length = 255, nullable = true)
    private String anhDaiDien;

//    @OneToMany(mappedBy = "tacGia", cascade = CascadeType.ALL)
//    private List<Sach> saches;

}
