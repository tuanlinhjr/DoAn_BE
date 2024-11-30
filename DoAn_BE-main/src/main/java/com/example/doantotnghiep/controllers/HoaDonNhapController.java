package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.DTO.ChiTietSachDTO;
import com.example.doantotnghiep.DTO.HoaDonNhapDTO;
import com.example.doantotnghiep.DTO.HoaDonNhapVaChiTiet;
import com.example.doantotnghiep.models.HoaDonNhap;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.repositories.ISachRepository;
import com.example.doantotnghiep.services.chitiethdn.IChiTietHDNService;
import com.example.doantotnghiep.services.chitietsach.IChiTietSachService;
import com.example.doantotnghiep.services.hoadonnhap.IHoaDonNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class HoaDonNhapController {
    @Autowired
    private IHoaDonNhapService hoaDonNhapService;

    @Autowired
    private IChiTietHDNService chiTietHDNService;

    @Autowired
    private IChiTietSachService chiTietSachService;

    @Autowired
    private ISachRepository sachRepository;

//    @PostMapping("/addhoadonnhap")
//    public ResponseEntity<HoaDonNhapDTO> addHoaDonNhapAndChiTietHDN(@RequestBody HoaDonNhapDTO hoaDonNhapDTO) {
//
//        try {
//            HoaDonNhapDTO savedHoaDonNhap = hoaDonNhapService.addHoaDonNhap(hoaDonNhapDTO);
//            return new ResponseEntity<>(savedHoaDonNhap, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/chitiethdn")
//    public ResponseEntity<ChiTietHDNDTO> addChiTietHDN(@RequestBody ChiTietHDNDTO chiTietHDNDTO) {
//
//        try {
//            ChiTietHDNDTO saveChiTietHDN = chiTietHDNService.addChiTietHDN(chiTietHDNDTO);
//            return new ResponseEntity<>(saveChiTietHDN, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @PostMapping("/addhoadonnhap")
    public ResponseEntity<Object> addHoaDonNhapAndChiTietHDN(@RequestBody HoaDonNhapVaChiTiet dto) {

        try {
            HoaDonNhapDTO hoaDonNhapDTO = dto.getHoaDonNhapDTO();
            List<ChiTietHDNDTO> chiTietHDNDTOList = dto.getChiTietHDNDTOList();
            double tongTien = 0;
            for (ChiTietHDNDTO chiTietHDNDTO : chiTietHDNDTOList) {
                // Lấy sách từ mã sách
                Sach sach = sachRepository.findById(chiTietHDNDTO.getMaSach())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy sách có mã là: " + chiTietHDNDTO.getMaSach()));

                // Tính tổng tiền cho từng chi tiết hóa đơn
                tongTien += chiTietHDNDTO.getSoLuong() * sach.getGiaBia();
            }
            hoaDonNhapDTO.setTongTien(tongTien);

            HoaDonNhapDTO savedHoaDonNhapDTO = hoaDonNhapService.addHoaDonNhap(hoaDonNhapDTO);

            for(ChiTietHDNDTO chiTietHDNDTO : chiTietHDNDTOList) {
                chiTietHDNDTO.setMaHDN(savedHoaDonNhapDTO.getMaHDN());
                chiTietHDNService.addChiTietHDN(chiTietHDNDTO);
                for (int i = 0; i < chiTietHDNDTO.getSoLuong(); i++) {
                    ChiTietSachDTO newChiTietSachDTO = new ChiTietSachDTO();
                    newChiTietSachDTO.setMaSach(chiTietHDNDTO.getMaSach());
                    // Các thông tin khác nếu cần
                    chiTietSachService.addChiTietSach(newChiTietSachDTO); // Thêm chi tiết sách cho từng sách
                }
            }

            return new ResponseEntity<>(savedHoaDonNhapDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/listHDN")
    public List<HoaDonNhap> getAllHDN() {
        return hoaDonNhapService.getAll();
    }





}
