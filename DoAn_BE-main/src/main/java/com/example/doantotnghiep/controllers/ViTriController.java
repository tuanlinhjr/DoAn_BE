package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.ViTriDTO;
import com.example.doantotnghiep.services.vitri.IViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class ViTriController {
    @Autowired
    private IViTriService viTriService;

    @GetMapping(value = "/listViTri")
    public List<ViTriDTO> getAllViTri(){
        return viTriService.getAll();
    }
    @PostMapping(value = "/addViTri")
    public ResponseEntity<ViTriDTO> addViTri(@RequestBody ViTriDTO viTriDTO) {
        return ResponseEntity.ok(viTriService.addViTri(viTriDTO));
    }

    @PutMapping(value = "/updateViTri/{maViTri}")
    public ResponseEntity<ViTriDTO> updateViTri(@PathVariable Long maViTri, @RequestBody ViTriDTO viTriDetails) {
        return ResponseEntity.ok(viTriService.updateViTri(maViTri, viTriDetails));
    }
}
