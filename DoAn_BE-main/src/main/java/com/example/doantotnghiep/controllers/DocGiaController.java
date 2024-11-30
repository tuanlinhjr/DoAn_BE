package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.DTO.PhongBanDTO;
import com.example.doantotnghiep.models.DocGia;
import com.example.doantotnghiep.services.docgia.IDocGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class DocGiaController {
    @Autowired
    private IDocGiaService docGiaService;

    @GetMapping(value = "/listDocGia")
    public List<DocGia> getAllDocGia(){
        return docGiaService.getAll();
    }

    @PostMapping(value = "/addDocGia")
    public ResponseEntity<?> addDocGia(@RequestBody DocGiaDTO docGiaDTO) {
        try {
            docGiaService.addDocGia(docGiaDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Thêm đọc giả thất bại: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value = "/updateDocGia/{maDocGia}")
    public ResponseEntity<?> updateDocGia(@PathVariable Long maDocGia, @RequestBody DocGiaDTO docGiaDetails) {
        try {
            docGiaService.updateDocGia(maDocGia, docGiaDetails);
            return new ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Update đọc giả thất bại: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("findByMaDocGia/{maDocGia}")
    public ResponseEntity<DocGiaDTO> getDocGiaById(@PathVariable Long maDocGia) {
        Optional<DocGiaDTO> docgia = docGiaService.finById(maDocGia);
        if (docgia.isPresent()) {
            return ResponseEntity.ok(docgia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/importDocGia")
    public ResponseEntity<?> importDocGia(@RequestParam("file") MultipartFile file) {

        try {
            // Sử dụng thư mục tạm thời của hệ thống
            String tempDir = System.getProperty("java.io.tmpdir");
            Path tempFilePath = Paths.get(tempDir, file.getOriginalFilename());
            Files.write(tempFilePath, file.getBytes());

            // Truyền đường dẫn tệp tạm thời đến dịch vụ để xử lý
            docGiaService.importDocGiaFromExcel(tempFilePath.toString());

            // Xóa tệp tạm sau khi xử lý xong
            Files.delete(tempFilePath);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
