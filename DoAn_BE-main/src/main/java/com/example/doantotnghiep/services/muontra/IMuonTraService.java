package com.example.doantotnghiep.services.muontra;

import com.example.doantotnghiep.DTO.ChiTietMuonTraDTO;
import com.example.doantotnghiep.DTO.MuonTraDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.models.MuonTra;
import com.example.doantotnghiep.models.NhanVien;

import java.util.List;
import java.util.Optional;

public interface IMuonTraService {

    MuonTraDTO addMuonTra(MuonTraDTO muonTraDTO) throws Exception;
    MuonTraDTO updateMuonTra(Long maMuonTra);

    void xoaMuonTra(Long maMuonTra);

    Optional<MuonTraDTO> findById(Long maMuonTra);

    List<MuonTra> getAll();

    List<MuonTra> getMuonByMaDocGia(Long maDocGia);
    List<MuonTra> getTraByMaDocGia(Long maDocGia);

    MuonTraDTO yeuCauGiaHan(Long maMuonTra);
    MuonTraDTO xacNhanGiaHan(Long maMuonTra);

    List<MuonTra> danhSachGiaHan();

    MuonTraDTO huyGiaHan(Long maMuonTra);

}
