package com.example.doantotnghiep.DTO;

import lombok.Data;

import java.util.List;
@Data
public class MuonTraVaChiTiet {
    private MuonTraDTO muonTraDTO;
    private List<ChiTietMuonTraDTO> chiTietMuonTraDTOList;

    public List<ChiTietMuonTraDTO> getChiTietMuonTraDTOList() {
        return chiTietMuonTraDTOList;
    }

    public void setChiTietMuonTraDTOList(List<ChiTietMuonTraDTO> chiTietMuonTraDTOList) {
        this.chiTietMuonTraDTOList = chiTietMuonTraDTOList;
    }



    public MuonTraVaChiTiet(MuonTraDTO muonTraDTO, ChiTietMuonTraDTO chiTietMuonTraDTO) {
        this.muonTraDTO = muonTraDTO;
//        this.ch = chiTietHDNDTO;
    }

    public MuonTraDTO getMuonTraDTO() {
        return muonTraDTO;
    }

    public void setMuonTraDTO(MuonTraDTO muonTraDTO) {
        this.muonTraDTO = muonTraDTO;
    }
}
