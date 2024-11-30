package com.example.doantotnghiep.services.muontra;

import com.example.doantotnghiep.DTO.ChiTietMuonTraDTO;
import com.example.doantotnghiep.models.ChiTietMuonTra;
import com.example.doantotnghiep.models.ChiTietSach;

import java.util.List;
import java.util.Optional;

public interface IChiTietMuonTraService {
    ChiTietMuonTraDTO addChiTiet(ChiTietMuonTraDTO chiTietMuonTraDTO) throws Exception;

    ChiTietMuonTraDTO updateChiTiet(Long maCTMuonTra, ChiTietMuonTraDTO chiTietMuonTraDTO);

    void xoaChiTiet(Long maCTMuonTra);

    Optional<ChiTietMuonTraDTO> findById(Long maCTMuonTra);

    List<ChiTietMuonTra> getAll();

    List<ChiTietMuonTra> findByMuonTra(Long maMuonTra);

    Long countCTMuonTra(Long maMuonTra);
    Long sumTienPhat(Long maMuonTra);
    List<ChiTietMuonTra> getSachHong();
}
