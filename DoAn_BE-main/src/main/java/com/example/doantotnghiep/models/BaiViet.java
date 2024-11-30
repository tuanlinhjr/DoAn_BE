package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "baiviet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maBaiViet;
    @Column(length = 255, nullable = true)
    private String tieuDe;
    @Column(length = 1000, nullable = true)
    private String noiDung;
    @Column(length = 255, nullable = true)
    private String anhBaiViet;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;
}
