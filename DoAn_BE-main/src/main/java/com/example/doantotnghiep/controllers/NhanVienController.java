package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.ChangePass;
import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.DTO.SachDTO;
import com.example.doantotnghiep.models.NhanVien;
import com.example.doantotnghiep.services.nhanvien.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class NhanVienController {
    @Autowired
    private INhanVienService nhanVienService;

    @GetMapping(value = "/listNhanVien")
    public List<NhanVien> getAllNhanVien(){
        return nhanVienService.getAll();
    }

    @PostMapping(value = "/addNV")
    public ResponseEntity<?> addNV(@RequestBody NhanVienDTO nhanVienDTO) {
        try {
            nhanVienService.addNhanVien(nhanVienDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping(value = "/updateNhanVien/{maNV}")
    public ResponseEntity<?> updateNhanVien(@PathVariable Long maNV, @RequestBody NhanVienDTO nVDetails) {
        try {
            nhanVienService.updateNhanVien(maNV, nVDetails);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/updateTTNhanVien/{maNV}")
    public ResponseEntity<?> updateTTNhanVien(@PathVariable Long maNV, @RequestBody NhanVienDTO nVDetails) {
        try {
            nhanVienService.updateTTNhanVien(maNV, nVDetails);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("findByMaNV/{maNV}")
    public ResponseEntity<NhanVienDTO> getNhanVienById(@PathVariable Long maNV) {
        Optional<NhanVienDTO> nhanvien = nhanVienService.findById(maNV);
        if (nhanvien.isPresent()) {
            return ResponseEntity.ok(nhanvien.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/import")
    public ResponseEntity<?> importNhanVien(@RequestParam("file") MultipartFile file) {

        try {
            // Sử dụng thư mục tạm thời của hệ thống
            String tempDir = System.getProperty("java.io.tmpdir");
            Path tempFilePath = Paths.get(tempDir, file.getOriginalFilename());
            Files.write(tempFilePath, file.getBytes());

            // Truyền đường dẫn tệp tạm thời đến dịch vụ để xử lý
            nhanVienService.importNhanVienFromExcel(tempFilePath.toString());

            // Xóa tệp tạm sau khi xử lý xong
            Files.delete(tempFilePath);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/doimatkhau/{maNV}")
    public ResponseEntity<String> changePassword(@PathVariable Long maNV, @RequestBody ChangePass changePass) {
        try {
            nhanVienService.changePassword(maNV, changePass);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
