package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.TheLoaiDTO;
import com.example.doantotnghiep.DTO.VaiTroDTO;
import com.example.doantotnghiep.services.vaitro.IVaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class VaiTroController {
    @Autowired
    private IVaiTroService vaiTroService;

    @GetMapping(value = "/listVaiTro")
    public List<VaiTroDTO> getAllVaiTro(){
        return vaiTroService.getAll();
    }
    @PostMapping(value = "/addVaiTro")
    public ResponseEntity<VaiTroDTO> addVaiTro(@RequestBody VaiTroDTO vaiTroDTO) {
        return ResponseEntity.ok(vaiTroService.addVaiTro(vaiTroDTO));
    }

    @PutMapping(value = "/updateVaiTro/{maVaiTro}")
    public ResponseEntity<VaiTroDTO> updateVaiTro(@PathVariable Long maVaiTro, @RequestBody VaiTroDTO vaiTroDetails) {
        return ResponseEntity.ok(vaiTroService.updateVaiTro(maVaiTro, vaiTroDetails));
    }

    @GetMapping("/getVaiTroById/{maVaiTro}")
    public ResponseEntity<VaiTroDTO> getVaiTroById(@PathVariable Long maVaiTro) {
        Optional<VaiTroDTO> vaiTro = vaiTroService.finById(maVaiTro);
        if (vaiTro.isPresent()) {
            return ResponseEntity.ok(vaiTro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
