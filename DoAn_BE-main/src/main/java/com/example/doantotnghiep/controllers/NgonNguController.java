package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.TheLoaiDTO;
import com.example.doantotnghiep.services.ngonngu.INgonNguService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class NgonNguController {
    @Autowired
    private INgonNguService ngonNguService;

    @GetMapping(value = "/listNgonNgu")
    public List<NgonNguDTO> getAllNgonNgu(){
        return ngonNguService.getAll();
    }
    @PostMapping(value = "/addNgonNgu")
    public ResponseEntity<NgonNguDTO> addNgonNgu(@RequestBody NgonNguDTO ngonNguDTO) {
        return ResponseEntity.ok(ngonNguService.addNgonNgu(ngonNguDTO));
    }

    @PutMapping(value = "/updateNgonNgu/{maNgonNgu}")
    public ResponseEntity<NgonNguDTO> updateNgonNgu(@PathVariable Long maNgonNgu, @RequestBody NgonNguDTO ngonNguDetails) {
        return ResponseEntity.ok(ngonNguService.updateNgonNgu(maNgonNgu, ngonNguDetails));
    }

    @DeleteMapping(value = "deleteNgonNgu/{maNgonNgu}")
    public ResponseEntity<String> deleteNgonNgu(@PathVariable Long maNgonNgu) {
        try {
            ngonNguService.xoaNgonNgu(maNgonNgu);
            return ResponseEntity.ok("Xóa ngôn ngữ thành công");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("findById/{maNgonNgu}")
    public ResponseEntity<NgonNguDTO> getTheLoaiById(@PathVariable Long maNgonNgu) {
        Optional<NgonNguDTO> theLoai = ngonNguService.finById(maNgonNgu);
        if (theLoai.isPresent()) {
            return ResponseEntity.ok(theLoai.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
