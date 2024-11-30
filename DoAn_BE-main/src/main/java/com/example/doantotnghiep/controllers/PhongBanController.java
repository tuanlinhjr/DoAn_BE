package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.NhaXuatBanDTO;
import com.example.doantotnghiep.DTO.PhongBanDTO;
import com.example.doantotnghiep.services.phongban.IPhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class PhongBanController {

    @Autowired
    private IPhongBanService phongBanService;

    @GetMapping(value = "/listPhongBan")
    public List<PhongBanDTO> getAllPhongBan(){
        return phongBanService.getAll();
    }
    @PostMapping(value = "/addPhongBan")
    public ResponseEntity<PhongBanDTO> addPhongBan(@RequestBody PhongBanDTO phongBanDTO) {
        return ResponseEntity.ok(phongBanService.addPhongBan(phongBanDTO));
    }

    @PutMapping(value = "/updatePhongBan/{maPhongBan}")
    public ResponseEntity<PhongBanDTO> updatePhongBan(@PathVariable Long maPhongBan, @RequestBody PhongBanDTO phongBanDetails) {
        return ResponseEntity.ok(phongBanService.updatePhongBan(maPhongBan, phongBanDetails));
    }
    @GetMapping("findByMaPhongBan/{maPhongBan}")
    public ResponseEntity<PhongBanDTO> getPhongBanById(@PathVariable Long maPhongBan) {
        Optional<PhongBanDTO> phongban = phongBanService.finById(maPhongBan);
        if (phongban.isPresent()) {
            return ResponseEntity.ok(phongban.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
