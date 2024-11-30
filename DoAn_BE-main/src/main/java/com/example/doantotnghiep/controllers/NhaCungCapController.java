package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.NgonNguDTO;
import com.example.doantotnghiep.DTO.NhaCungCapDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.services.nhacungcap.INhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class NhaCungCapController {
    @Autowired
    private INhaCungCapService nhaCungCapService;

    @GetMapping(value = "/listNCC")
    public List<NhaCungCapDTO> getAllNCC(){
        return nhaCungCapService.getAll();
    }
    @PostMapping(value = "/addNCC")
    public ResponseEntity<NhaCungCapDTO> addNCC(@RequestBody NhaCungCapDTO nhaCungCapDTO) {
        return ResponseEntity.ok(nhaCungCapService.addNCC(nhaCungCapDTO));
    }

    @PutMapping(value = "/updateNCC/{maNCC}")
    public ResponseEntity<NhaCungCapDTO> updateNCC(@PathVariable Long maNCC, @RequestBody NhaCungCapDTO nCCDetails) {
        return ResponseEntity.ok(nhaCungCapService.updateNCC(maNCC, nCCDetails));
    }
    @GetMapping("findByMaNcc/{maNcc}")
    public ResponseEntity<NhaCungCapDTO> getNCCById(@PathVariable Long maNcc) {
        Optional<NhaCungCapDTO> ncc = nhaCungCapService.finById(maNcc);
        if (ncc.isPresent()) {
            return ResponseEntity.ok(ncc.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
