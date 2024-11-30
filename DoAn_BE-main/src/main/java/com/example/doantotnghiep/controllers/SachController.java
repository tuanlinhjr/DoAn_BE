package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.SachDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.models.ChiTietSach;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.services.chitietsach.ChiTietSachService;
import com.example.doantotnghiep.services.chitietsach.IChiTietSachService;
import com.example.doantotnghiep.services.sach.ISachService;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class SachController {


    @Autowired
    private ISachService sachService;


    @Autowired
    private IChiTietSachService chiTietSachService;

    @GetMapping(value = "/listCTSach")
    public List<ChiTietSach> getAllCTSach() {
        return chiTietSachService.getAll();
    }

    @GetMapping(value = "/listSach")
    public List<Sach> getAllSach() {
        return sachService.getAll();
    }

    //    @PostMapping(value = "/addSach")
//    public ResponseEntity<?> addSach(@RequestBody SachDTO sachDTO) {
//        try {
//            sachService.addSach(sachDTO);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
    @PostMapping(value = "/addSach", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addSach(@ModelAttribute SachDTO sachDTO,
                                     HttpServletRequest request) {

        boolean checkInsert = sachService.addSach(sachDTO, request);
        if (checkInsert)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping(value = "/updateSach/{maSach}")
    public ResponseEntity<?> updateSach(@PathVariable Long maSach, @ModelAttribute SachDTO sachDetails, HttpServletRequest request) {
        try {
            sachService.updateSach(maSach, sachDetails, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/updateCTSach/{maChiTietSach}")
    public ResponseEntity<?> updateSach(@PathVariable Long maChiTietSach) {
        try {
            chiTietSachService.updateTinhTrang(maChiTietSach);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findByMaSach/{maSach}")
    public ResponseEntity<Sach> getSachById(@PathVariable Long maSach) {
        Optional<Sach> sach = sachService.findById(maSach);
        if (sach.isPresent()) {
            return ResponseEntity.ok(sach.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/listCTSach/{maSach}")
    public List<ChiTietSach> getCTSach(@PathVariable Long maSach) {
        return chiTietSachService.findByCTSach(maSach);
    }

    @GetMapping(value = "/listChiTietSach")
    public List<ChiTietSach> getCTSachAll() {
        return chiTietSachService.getAll();
    }

    @GetMapping(value = "/listsachbytheloai/{maTheLoai}")
    public List<Sach> getSachByTheLoai(@PathVariable Long maTheLoai) {
        return sachService.findSachByMaTL(maTheLoai);
    }

    @GetMapping(value = "/listctsachbysach/{maSach}")
    public List<ChiTietSach> getCTSachBySach(@PathVariable Long maSach) {
        return chiTietSachService.findByCTSach(maSach);
    }

    @GetMapping(value = "/tongSoSach")
    public Long tongSoSach() {
        return chiTietSachService.tongSoSach();
    }

    @GetMapping(value = "/soSachDangMuon")
    public Long soSachDangMuon() {
        return chiTietSachService.soSachDangMuon();
    }

    @GetMapping(value = "/soSachCoSan")
    public Long soSachCoSan() {
        return chiTietSachService.soSachCoSan();
    }

    @GetMapping(value = "/soSachHong")
    public Long soSachHong() {
        return chiTietSachService.soSachHong();
    }
}
