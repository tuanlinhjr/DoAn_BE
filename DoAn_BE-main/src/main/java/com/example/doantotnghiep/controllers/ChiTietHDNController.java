package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.ChiTietHDNDTO;
import com.example.doantotnghiep.models.ChiTietHDN;
import com.example.doantotnghiep.services.chitiethdn.IChiTietHDNService;
import com.example.doantotnghiep.services.hoadonnhap.IHoaDonNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class ChiTietHDNController {
    @Autowired
    private IChiTietHDNService chiTietHDNService;
    @GetMapping(value = "/listCTHDN/{maHDN}")
    public List<ChiTietHDN> getCTHDNByMaHDN(@PathVariable Long maHDN) {
        return chiTietHDNService.findByCTHDN(maHDN);
    }
}
