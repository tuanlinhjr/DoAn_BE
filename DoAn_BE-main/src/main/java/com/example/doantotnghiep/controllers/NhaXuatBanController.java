package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.NhaCungCapDTO;
import com.example.doantotnghiep.DTO.NhaXuatBanDTO;
import com.example.doantotnghiep.services.nhaxuatban.INhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class NhaXuatBanController {
    @Autowired
    private INhaXuatBanService nhaXuatBanService;

    @GetMapping(value = "/listNXB")
    public List<NhaXuatBanDTO> getAllNXB(){
        return nhaXuatBanService.getAll();
    }
    @PostMapping(value = "/addNXB")
    public ResponseEntity<NhaXuatBanDTO> addNXB(@RequestBody NhaXuatBanDTO nhaXuatBanDTO) {
        return ResponseEntity.ok(nhaXuatBanService.addNXB(nhaXuatBanDTO));
    }

    @PutMapping(value = "/updateNXB/{maNxb}")
    public ResponseEntity<NhaXuatBanDTO> updateNXB(@PathVariable Long maNxb, @RequestBody NhaXuatBanDTO nXBDetails) {
        return ResponseEntity.ok(nhaXuatBanService.updateNXB(maNxb, nXBDetails));
    }
    @GetMapping("findByMaNxb/{maNxb}")
    public ResponseEntity<NhaXuatBanDTO> getNXBById(@PathVariable Long maNxb) {
        Optional<NhaXuatBanDTO> nxb = nhaXuatBanService.finById(maNxb);
        if (nxb.isPresent()) {
            return ResponseEntity.ok(nxb.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
