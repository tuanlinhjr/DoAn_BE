package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ngonngu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgonNgu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNgonNgu;
    @Column(length = 255, nullable = true)
    private String tenNgonNgu;

//    @OneToMany(mappedBy = "ngonNgu", cascade = CascadeType.ALL)
//    private List<Sach> saches;
}
