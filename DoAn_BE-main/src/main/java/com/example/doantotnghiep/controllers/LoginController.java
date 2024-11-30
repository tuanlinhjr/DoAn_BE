package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.LoginDTO;
import com.example.doantotnghiep.models.DocGia;
import com.example.doantotnghiep.models.NhanVien;
import com.example.doantotnghiep.services.docgia.DocGiaService;
import com.example.doantotnghiep.services.nhanvien.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class LoginController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private DocGiaService docGiaService;

    @PostMapping(value = "/loginNhanVien")
    public ResponseEntity<?> loginNhanVien(@RequestBody LoginDTO loginDTO){
        Optional<NhanVien> nhanVien = nhanVienService.checkUsernameAndPassWord(loginDTO.getUserName(), loginDTO.getPassWord());
        if(nhanVien.isPresent())
            return new ResponseEntity<>(nhanVien, HttpStatus.OK);
        return new ResponseEntity<>("Sai tên đăng nhập hoặc mật khẩu",HttpStatus.UNAUTHORIZED);
    }
    @PostMapping(value = "/loginDocGia")
    public ResponseEntity<?> loginDocGia(@RequestBody LoginDTO loginDTO){
        Optional<DocGia> docGia = docGiaService.checkUsernameAndPassWord(loginDTO.getUserName(), loginDTO.getPassWord());
        if(docGia.isPresent())
            return new ResponseEntity<>(docGia, HttpStatus.OK);
        return new ResponseEntity<>("Sai tên đăng nhập hoặc mật khẩu",HttpStatus.UNAUTHORIZED);
    }
}
