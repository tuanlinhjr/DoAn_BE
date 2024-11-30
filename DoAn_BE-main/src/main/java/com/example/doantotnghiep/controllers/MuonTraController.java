package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.ChiTietMuonTraDTO;
import com.example.doantotnghiep.DTO.ChiTietSachDTO;
import com.example.doantotnghiep.DTO.MuonTraDTO;
import com.example.doantotnghiep.DTO.MuonTraVaChiTiet;
import com.example.doantotnghiep.models.*;
import com.example.doantotnghiep.repositories.IChiTietSachRepository;
import com.example.doantotnghiep.services.muontra.ChiTietMuonTraService;
import com.example.doantotnghiep.services.muontra.MuonTraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class MuonTraController {
    @Autowired
    private MuonTraService muonTraService;
    @Autowired
    private ChiTietMuonTraService chiTietMuonTraService;

    @Autowired
    private IChiTietSachRepository chiTietSachRepository;

    @PostMapping("/addphieumuon")
    public ResponseEntity<Object> addPhieuMuon(@RequestBody MuonTraVaChiTiet muonTraVaChiTiet){
        try{
            MuonTraDTO muonTraDTO = muonTraVaChiTiet.getMuonTraDTO();
            List<ChiTietMuonTraDTO> chiTietMuonTraDTOList = muonTraVaChiTiet.getChiTietMuonTraDTOList();

            MuonTraDTO saveMuonTra = muonTraService.addMuonTra(muonTraDTO);
            for(ChiTietMuonTraDTO chiTietMuonTraDTO: chiTietMuonTraDTOList){
                chiTietMuonTraDTO.setMaMuonTra(saveMuonTra.getMaMuonTra());
                ChiTietSach chiTietSach = chiTietSachRepository.findById(chiTietMuonTraDTO.getMaChiTietSach())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết sách có mã là: " + chiTietMuonTraDTO.getMaChiTietSach()));
                chiTietSach.setTinhTrangSach("Đang Mượn");
                chiTietMuonTraService.addChiTiet(chiTietMuonTraDTO);
            }
            return new ResponseEntity<>(saveMuonTra, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/listctMuonTra/{maMuonTra}")
    public List<ChiTietMuonTra> getCTMuonTraByMaMuonTra(@PathVariable Long maMuonTra) {
        return chiTietMuonTraService.findByMuonTra(maMuonTra);
    }
    @GetMapping(value = "/listMuonTra")
    public List<MuonTra> getAllMuonTra() {
        return muonTraService.getAll();
    }

    @PutMapping("updatePhieuMuon/{maMuonTra}")
    public ResponseEntity<MuonTraDTO> updateMuonTra(@PathVariable Long maMuonTra) {
        try {
            MuonTraDTO updatedMuonTra = muonTraService.updateMuonTra(maMuonTra);

            return ResponseEntity.ok(updatedMuonTra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("updateCTMuonTra/{maCTMuonTra}")
    public ResponseEntity<ChiTietMuonTraDTO> updateChiTiet(@PathVariable Long maCTMuonTra, @RequestBody ChiTietMuonTraDTO chiTietMuonTraDTO) {
        try {
            ChiTietMuonTraDTO updatedChiTiet = chiTietMuonTraService.updateChiTiet(maCTMuonTra, chiTietMuonTraDTO);
            return ResponseEntity.ok(updatedChiTiet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/yeuCauGiaHan/{maMuonTra}")
    public ResponseEntity<?> yeuCauGiaHan(@PathVariable Long maMuonTra){
        try {
            MuonTraDTO muonTraDTO = muonTraService.yeuCauGiaHan(maMuonTra);
            return new ResponseEntity<>(muonTraDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(value = "/xacNhanGiaHan/{maMuonTra}")
    public ResponseEntity<?> xacNhanGiaHan(@PathVariable Long maMuonTra){
        try {
            MuonTraDTO muonTraDTO = muonTraService.xacNhanGiaHan(maMuonTra);
            return new ResponseEntity<>(muonTraDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(value = "/huyGiaHan/{maMuonTra}")
    public ResponseEntity<?> huyGiaHan(@PathVariable Long maMuonTra){
        try {
            MuonTraDTO muonTraDTO = muonTraService.huyGiaHan(maMuonTra);
            return new ResponseEntity<>(muonTraDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/countChiTietMuonTra")
    public Long countChiTietMuonTra(@RequestParam Long maMuonTra) {
        return chiTietMuonTraService.countCTMuonTra(maMuonTra);
    }
    @GetMapping(value = "/sumTienPhat")
    public Long sumTienPhat(@RequestParam Long maMuonTra){
        return chiTietMuonTraService.sumTienPhat(maMuonTra);
    }

    @GetMapping("/countMuon")
    public Map<Integer, Long> getBorrowedBooksMonthly(@RequestParam("year") int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        return muonTraService.countMuonSachGroupByMonth(startDate, endDate);
    }

    @GetMapping("/countTra")
    public Map<Integer, Long> getReturnedBooksMonthly(@RequestParam("year") int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        return muonTraService.countTraSachGroupByMonth(startDate, endDate);
    }

    @GetMapping("/top5SachMuon")
    public List<Map<String, Object>> getTop5BorrowedBooks() {
        return chiTietMuonTraService.getTop5BorrowedBooks();
    }

    @GetMapping("/top5DocGia")
    public List<Map<String, Object>> getTopUsersByBorrowCount() {
        return muonTraService.getTopUsersByBorrowCount();
    }

    @GetMapping(value = "/lichsumuontra/{maDocGia}")
    public List<MuonTra> getLichSu(@PathVariable Long maDocGia){
        return muonTraService.getMuonByMaDocGia(maDocGia);
    }
    @GetMapping(value = "/lichsutra/{maDocGia}")
    public List<MuonTra> getLichSuTra(@PathVariable Long maDocGia){
        return muonTraService.getTraByMaDocGia(maDocGia);
    }

    @GetMapping(value = "/sachHong")
    public List<ChiTietMuonTra> getSachHong(){
        return chiTietMuonTraService.getSachHong();
    }
    @GetMapping(value = "/danhSachGiaHan")
    public List<MuonTra> danhSachGiaHan(){
        return muonTraService.danhSachGiaHan();
    }


}
