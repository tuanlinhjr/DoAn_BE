package com.example.doantotnghiep.controllers;


import com.example.doantotnghiep.DTO.TheLoaiDTO;

import com.example.doantotnghiep.models.TheLoai;
import com.example.doantotnghiep.services.theloai.ITheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class TheLoaiController {
    @Autowired
    private ITheLoaiService theLoaiService;

    @GetMapping(value = "/listTheLoai")
    public List<TheLoaiDTO> getAllTheLoai(){
        return theLoaiService.getAll();
    }
    @PostMapping(value = "/addTheLoai")
    public ResponseEntity<TheLoaiDTO> addTheLoai(@RequestBody TheLoaiDTO theLoaiDTO) {
        return ResponseEntity.ok(theLoaiService.addTheLoai(theLoaiDTO));
    }

    @PutMapping(value = "/updateTheLoai/{maTheLoai}")
    public ResponseEntity<TheLoaiDTO> updateTheLoai(@PathVariable Long maTheLoai, @RequestBody TheLoaiDTO theLoaiDetails) {
        return ResponseEntity.ok(theLoaiService.updateTheLoai(maTheLoai, theLoaiDetails));
    }

    @DeleteMapping(value = "deleteTheLoai/{maTheLoai}")
    public ResponseEntity<?> deleteTheLoai(@PathVariable Long maTheLoai) {
        try {
            theLoaiService.xoaTheLoai(maTheLoai);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/existsTenTL/{tenTheLoai}")
    public ResponseEntity<Boolean> checkTenTheLoai(@RequestParam String tenTheLoai) {
        boolean exists = theLoaiService.isTenTheLoaiExists(tenTheLoai);
        return ResponseEntity.ok().body(exists);
    }

    @GetMapping("/getTheLoaiById/{maTheLoai}")
    public ResponseEntity<TheLoaiDTO> getTheLoaiById(@PathVariable Long maTheLoai) {
        Optional<TheLoaiDTO> theLoai = theLoaiService.finById(maTheLoai);
        if (theLoai.isPresent()) {
            return ResponseEntity.ok(theLoai.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
