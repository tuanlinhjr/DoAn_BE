package com.example.doantotnghiep.services.baiviet;

import com.example.doantotnghiep.DTO.BaiVietDTO;

import java.util.List;
import java.util.Optional;

public interface IBaiVietService {
    BaiVietDTO addBaiViet(BaiVietDTO baiVietDTO);
    BaiVietDTO updateBaiViet(Long maBaiViet, BaiVietDTO baiVietDetails);

    void xoaBaiViet(Long maBaiViet);

    Optional<BaiVietDTO> finById(Long maBaiViet);

    List<BaiVietDTO> getAll();
}
