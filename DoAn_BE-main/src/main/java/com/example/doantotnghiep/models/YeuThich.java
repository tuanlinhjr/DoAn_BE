package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "yeuthich")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maYeuThich;

    @ManyToOne
    @JoinColumn(name = "maDocGia")
    private DocGia docGia;

    @ManyToOne
    @JoinColumn(name = "maSach")
    private Sach sach;
}
