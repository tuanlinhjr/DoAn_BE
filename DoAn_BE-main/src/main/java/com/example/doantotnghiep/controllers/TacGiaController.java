package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.NhaXuatBanDTO;
import com.example.doantotnghiep.DTO.TacGiaDTO;
import com.example.doantotnghiep.services.tacgia.ITacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class TacGiaController {
    @Autowired
    private ITacGiaService tacGiaService;

    @GetMapping(value = "/listTacGia")
    public List<TacGiaDTO> getAllTacGia(){
        return tacGiaService.getAll();
    }
    @PostMapping(value = "/addTacGia")
    public ResponseEntity<TacGiaDTO> addTacGia(@RequestBody TacGiaDTO tacGiaDTO) {
        return ResponseEntity.ok(tacGiaService.addTacGia(tacGiaDTO));
    }

    @PutMapping(value = "/updateTacGia/{maTacGia}")
    public ResponseEntity<TacGiaDTO> updateTacGia(@PathVariable Long maTacGia, @RequestBody TacGiaDTO tacGiaDetails) {
        return ResponseEntity.ok(tacGiaService.updateTacGia(maTacGia, tacGiaDetails));
    }
    @GetMapping("findByMaTacGia/{maTacGia}")
    public ResponseEntity<TacGiaDTO> getNXBById(@PathVariable Long maTacGia) {
        Optional<TacGiaDTO> tacGia = tacGiaService.finById(maTacGia);
        if (tacGia.isPresent()) {
            return ResponseEntity.ok(tacGia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
