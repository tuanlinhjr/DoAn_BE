package com.example.doantotnghiep.services.docgia;

import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.controllers.ExcelReader;
import com.example.doantotnghiep.controllers.ExcelRenderDocGia;
import com.example.doantotnghiep.models.DocGia;
import com.example.doantotnghiep.models.NhanVien;
import com.example.doantotnghiep.models.PhongBan;
import com.example.doantotnghiep.models.VaiTro;
import com.example.doantotnghiep.repositories.IDocGiaRepository;
import com.example.doantotnghiep.repositories.IVaiTroRepository;
import com.example.doantotnghiep.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocGiaService implements IDocGiaService{
    @Autowired
    private IDocGiaRepository docGiaRepository;

    @Autowired
    private IVaiTroRepository vaiTroRepository;
    @Override
    public DocGiaDTO addDocGia(DocGiaDTO docGiaDTO) throws Exception {
        try {
            if (docGiaRepository.existsByMaDocGia(docGiaDTO.getMaDocGia())) {
                throw new IllegalArgumentException("Mã đọc giả đã tồn tại");
            }

            if (docGiaRepository.existsByEmail(docGiaDTO.getEmail())) {
                throw new IllegalArgumentException("Email đã tồn tại");
            }

            if (docGiaRepository.existsBySoDienThoai(docGiaDTO.getSoDienThoai())) {
                throw new IllegalArgumentException("Số điện thoại đã tồn tại");
            }

            DocGia docGia = new DocGia();
            docGia.setMaDocGia(docGiaDTO.getMaDocGia());
            docGia.setEmail(docGiaDTO.getEmail());
            docGia.setGioiTinh(docGiaDTO.getGioiTinh());
            docGia.setTenDocGia(docGiaDTO.getTenDocGia());
            docGia.setNamSinh(docGiaDTO.getNamSinh());
            docGia.setSoDienThoai(docGiaDTO.getSoDienThoai());
            docGia.setUserName(docGiaDTO.getMaDocGia().toString());
            docGia.setPassWord("123456");
            docGia.setTrangThaiHoatDong(docGiaDTO.getTrangThaiHoatDong());
            VaiTro vaiTro = vaiTroRepository.findById(docGiaDTO.getMaVaiTro())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò có mã là: " + docGiaDTO.getMaVaiTro()));
            docGia.setVaiTro(vaiTro);

            return DocGiaDTO.fromEntity(docGiaRepository.save(docGia));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Đã xảy ra lỗi khi thêm Đọc Giả", e);
        }
    }


    @Override
    public DocGiaDTO updateDocGia(Long maDocGia, DocGiaDTO docGiaDetails) {
        try {

            DocGia docGia = docGiaRepository.findById(maDocGia)
                    .orElseThrow(()-> new RuntimeException("Không tìm thấy đọc gi có mã là: " + maDocGia));
            docGia.setEmail(docGiaDetails.getEmail());
            docGia.setGioiTinh(docGiaDetails.getGioiTinh());
            docGia.setTenDocGia(docGiaDetails.getTenDocGia());
            docGia.setNamSinh(docGiaDetails.getNamSinh());
            docGia.setSoDienThoai(docGiaDetails.getSoDienThoai());
            return DocGiaDTO.fromEntity(docGiaRepository.save(docGia));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Đã xảy ra lỗi khi sửa thông tin độc giả", e);
        }

    }

    @Override
    public void xoaDocGia(Long maDocGia) {

    }

    @Override
    public Optional<DocGiaDTO> finById(Long maDocGia) {
        return docGiaRepository.findById(maDocGia)
                .stream().findFirst().map(DocGiaDTO::fromEntity);
    }

    @Override
    public List<DocGia> getAll() {
//        return docGiaRepository.findAll()
//                .stream().map(DocGiaDTO::fromEntity).collect(Collectors.toList());
        return docGiaRepository.findAll();
    }

    @Override
    public void importDocGiaFromExcel(String filePath) {
        ExcelRenderDocGia excelReader = new ExcelRenderDocGia();
        try {
            List<DocGiaDTO> docGiaList = excelReader.readExcelFile(filePath);
            for (DocGiaDTO docGiaDTO : docGiaList) {
                DocGia docGia = new DocGia();
                docGia.setMaDocGia(docGiaDTO.getMaDocGia());
                docGia.setTenDocGia(docGiaDTO.getTenDocGia());
                docGia.setGioiTinh(docGiaDTO.getGioiTinh());
                docGia.setSoDienThoai(docGiaDTO.getSoDienThoai());
                docGia.setNamSinh(docGiaDTO.getNamSinh());
                docGia.setEmail(docGiaDTO.getEmail());
                docGia.setUserName(docGiaDTO.getUserName());
                docGia.setPassWord(EncodeUtil.EncodeBase64PassWord(docGiaDTO.getPassWord()));
                docGia.setTrangThaiHoatDong(docGiaDTO.getTrangThaiHoatDong());
                VaiTro vaiTro = vaiTroRepository.findById(docGiaDTO.getMaVaiTro())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò có mã là: " + docGiaDTO.getMaVaiTro()));
                docGia.setVaiTro(vaiTro);

                docGiaRepository.save(docGia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<DocGia> checkUsernameAndPassWord(String userName, String passWord){
        return docGiaRepository.findByUserNameAndPassWord(userName, EncodeUtil.EncodeBase64PassWord(passWord));
    }
}
