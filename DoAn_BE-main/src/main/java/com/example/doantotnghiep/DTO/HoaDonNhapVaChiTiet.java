package com.example.doantotnghiep.DTO;

import java.util.ArrayList;
import java.util.List;

public class HoaDonNhapVaChiTiet {
    private HoaDonNhapDTO hoaDonNhapDTO;
    private List<ChiTietHDNDTO> chiTietHDNDTOList;

    private List<ChiTietSachDTO> chiTietSachDTOList;

    public HoaDonNhapVaChiTiet() {
        this.chiTietHDNDTOList = new ArrayList<>();
    }

    // Các phương thức getter và setter cho hoaDonNhapDTO

    public List<ChiTietHDNDTO> getChiTietHDNDTOList() {
        return chiTietHDNDTOList;
    }

    public void setChiTietHDNDTOList(List<ChiTietHDNDTO> chiTietHDNDTOList) {
        this.chiTietHDNDTOList = chiTietHDNDTOList;
    }
    public List<ChiTietSachDTO> getChiTietSachDTOList() {
        return chiTietSachDTOList;
    }

    public void setChiTietSachDTOList(List<ChiTietSachDTO> chiTietSachDTOList) {
        this.chiTietSachDTOList = chiTietSachDTOList;
    }

    public HoaDonNhapVaChiTiet(HoaDonNhapDTO hoaDonNhapDTO, ChiTietHDNDTO chiTietHDNDTO) {
        this.hoaDonNhapDTO = hoaDonNhapDTO;
//        this.chiTietHDNDTO = chiTietHDNDTO;
    }

    public HoaDonNhapDTO getHoaDonNhapDTO() {
        return hoaDonNhapDTO;
    }

    public void setHoaDonNhapDTO(HoaDonNhapDTO hoaDonNhapDTO) {
        this.hoaDonNhapDTO = hoaDonNhapDTO;
    }

//    public ChiTietHDNDTO getChiTietHDNDTO() {
//        return chiTietHDNDTO;
//    }
//
//    public void setChiTietHDNDTO(ChiTietHDNDTO chiTietHDNDTO) {
//        this.chiTietHDNDTO = chiTietHDNDTO;
//    }
}
