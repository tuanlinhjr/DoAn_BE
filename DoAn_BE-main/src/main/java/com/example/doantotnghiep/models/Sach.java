package com.example.doantotnghiep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sach")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSach;
    @Column(length = 255, nullable = true)
    private String tenSach;

    private String anhBia;
    @Column(length = 255, nullable = true)
    private String tinhTrang;
    private Double giaBia;
    private Long namXuatBan;


    @ManyToOne
    @JoinColumn(name = "maNxb")
    private NhaXuatBan nhaXuatBan;


    @ManyToOne
    @JoinColumn(name = "maNgonNgu")
    private NgonNgu ngonNgu;

    @ManyToOne
    @JoinColumn(name = "maTacGia")
    private TacGia tacGia;

    @ManyToOne
    @JoinColumn(name = "maTheLoai")
    private TheLoai theLoai;

//    @OneToMany(mappedBy = "sach", cascade = CascadeType.ALL)
//    private List<ChiTietSach> chiTietSaches;

//    @OneToMany(mappedBy = "sach", cascade = CascadeType.ALL)
//    private List<YeuThich> yeuThiches;

//    @OneToMany(mappedBy = "sach", cascade = CascadeType.ALL)
//    private List<ChiTietHDN> chiTietHDNS;


}
