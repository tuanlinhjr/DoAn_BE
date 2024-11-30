package com.example.doantotnghiep.services.nhanvien;


import com.example.doantotnghiep.DTO.ChangePass;
import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import com.example.doantotnghiep.DTO.SachDTO;
import com.example.doantotnghiep.controllers.ExcelReader;
import com.example.doantotnghiep.models.PhongBan;
import com.example.doantotnghiep.models.NhanVien;
import com.example.doantotnghiep.models.Sach;
import com.example.doantotnghiep.models.VaiTro;
import com.example.doantotnghiep.repositories.INhanVienRepository;
import com.example.doantotnghiep.repositories.IPhongBanRepository;
import com.example.doantotnghiep.repositories.IVaiTroRepository;
import com.example.doantotnghiep.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhanVienService implements INhanVienService{

    @Autowired
    private INhanVienRepository nhanVienRepository;

    @Autowired
    private IVaiTroRepository vaiTroRepository;

    @Autowired
    private IPhongBanRepository phongBanRepository;
    @Override
    public NhanVienDTO addNhanVien(NhanVienDTO nhanVienDTO) throws Exception {
        try {
            if (nhanVienRepository.existsByMaNV(nhanVienDTO.getMaNV())) {
                throw new IllegalArgumentException("Mã nhân viên đã tồn tại");
            }

            if (nhanVienRepository.existsByEmail(nhanVienDTO.getEmail())) {
                throw new IllegalArgumentException("Email đã tồn tại");
            }

            if (nhanVienRepository.existsBySoDienThoai(nhanVienDTO.getSoDienThoai())) {
                throw new IllegalArgumentException("Số điện thoại đã tồn tại");
            }

            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV(nhanVienDTO.getMaNV());
            nhanVien.setEmail(nhanVienDTO.getEmail());
            nhanVien.setGioiTinh(nhanVienDTO.getGioiTinh());
            nhanVien.setTenNV(nhanVienDTO.getTenNV());
            nhanVien.setNamSinh(nhanVienDTO.getNamSinh());
            nhanVien.setSoDienThoai(nhanVienDTO.getSoDienThoai());
            nhanVien.setUserName(nhanVienDTO.getMaNV().toString());
            nhanVien.setPassWord(EncodeUtil.EncodeBase64PassWord("123456"));
            nhanVien.setTrangThaiHoatDong(nhanVienDTO.getTrangThaiHoatDong());
            VaiTro vaiTro = vaiTroRepository.findById(nhanVienDTO.getMaVaiTro())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò có mã là: " + nhanVienDTO.getMaVaiTro()));
            nhanVien.setVaiTro(vaiTro);

            PhongBan phongBan = phongBanRepository.findById(nhanVienDTO.getMaPhongBan())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban có mã là: " + nhanVienDTO.getMaPhongBan()));
            nhanVien.setPhongBan(phongBan);

            return NhanVienDTO.fromEntity(nhanVienRepository.save(nhanVien));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Đã xảy ra lỗi khi thêm nhân viên", e);
        }
    }

    @Override
    public NhanVienDTO updateNhanVien(Long maNV, NhanVienDTO nVDetails) {
        try {
            NhanVien nhanVien = nhanVienRepository.findById(maNV)
                    .orElseThrow(()-> new RuntimeException("Không tìm thấy nhân viên có mã là: " + maNV));
//            nhanVien.setMaNV(nVDetails.getMaNV());
            nhanVien.setEmail(nVDetails.getEmail());
            nhanVien.setGioiTinh(nVDetails.getGioiTinh());
            nhanVien.setTenNV(nVDetails.getTenNV());
            nhanVien.setNamSinh(nVDetails.getNamSinh());
            nhanVien.setSoDienThoai(nVDetails.getSoDienThoai());
            nhanVien.setUserName(nVDetails.getMaNV().toString());
            nhanVien.setPassWord(EncodeUtil.EncodeBase64PassWord(nVDetails.getPassWord()));
            nhanVien.setTrangThaiHoatDong(nVDetails.getTrangThaiHoatDong());
            VaiTro vaiTro = vaiTroRepository.findById(nVDetails.getMaVaiTro())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò có mã là: " + nVDetails.getMaVaiTro()));
            nhanVien.setVaiTro(vaiTro);

            PhongBan phongBan = phongBanRepository.findById(nVDetails.getMaPhongBan())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban có mã là: " + nVDetails.getMaPhongBan()));
            nhanVien.setPhongBan(phongBan);

            return NhanVienDTO.fromEntity(nhanVienRepository.save(nhanVien));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Đã xảy ra lỗi khi cập nhật nhân viên", e);
        }
    }

    @Override
    public NhanVienDTO updateTTNhanVien(Long maNV, NhanVienDTO nVDetails) {
        try {
            NhanVien nhanVien = nhanVienRepository.findById(maNV)
                    .orElseThrow(()-> new RuntimeException("Không tìm thấy nhân viên có mã là: " + maNV));
            nhanVien.setEmail(nVDetails.getEmail());
            nhanVien.setGioiTinh(nVDetails.getGioiTinh());
            nhanVien.setTenNV(nVDetails.getTenNV());
            nhanVien.setNamSinh(nVDetails.getNamSinh());
            nhanVien.setSoDienThoai(nVDetails.getSoDienThoai());

            return NhanVienDTO.fromEntity(nhanVienRepository.save(nhanVien));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Đã xảy ra lỗi khi cập nhật nhân viên", e);
        }
    }

    @Override
    public void importNhanVienFromExcel(String filePath) {
        ExcelReader excelReader = new ExcelReader();
        try {
            List<NhanVienDTO> nhanVienList = excelReader.readExcelFile(filePath);
            for (NhanVienDTO nhanVienDTO : nhanVienList) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(nhanVienDTO.getMaNV());
                nhanVien.setTenNV(nhanVienDTO.getTenNV());
                nhanVien.setGioiTinh(nhanVienDTO.getGioiTinh());
                nhanVien.setSoDienThoai(nhanVienDTO.getSoDienThoai());
                nhanVien.setNamSinh(nhanVienDTO.getNamSinh());
                nhanVien.setEmail(nhanVienDTO.getEmail());
                nhanVien.setUserName(nhanVienDTO.getUserName());
                nhanVien.setPassWord(EncodeUtil.EncodeBase64PassWord(nhanVienDTO.getPassWord()));
                nhanVien.setTrangThaiHoatDong(nhanVienDTO.getTrangThaiHoatDong());


                PhongBan phongBan = phongBanRepository.findById(nhanVienDTO.getMaPhongBan())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban có mã là: " + nhanVienDTO.getMaPhongBan()));
                nhanVien.setPhongBan(phongBan);
                VaiTro vaiTro = vaiTroRepository.findById(nhanVienDTO.getMaVaiTro())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò có mã là: " + nhanVienDTO.getMaVaiTro()));
                nhanVien.setVaiTro(vaiTro);

                nhanVienRepository.save(nhanVien);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaNhanVien(Long maNV) {

    }
    @Override
    public Optional<NhanVienDTO> findById(Long maNV) {
        return nhanVienRepository.findById(maNV)
                .stream().findFirst().map(NhanVienDTO::fromEntity);
    }
    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> checkUsernameAndPassWord(String userName, String passWord){
        return nhanVienRepository.findByUserNameAndPassWord(userName, EncodeUtil.EncodeBase64PassWord(passWord));
    }

    public Optional<NhanVien> checkUsernameExist(String userName){
        return nhanVienRepository.findByUserName(userName);
    }
    @Override
    public boolean changePassword(Long maNV, ChangePass changePass) {
        NhanVien nhanVien = nhanVienRepository.findById(maNV).orElse(null);
        if (nhanVien == null) {
            throw new RuntimeException("Employee not found");
        }

        String oldPassWord = changePass.getOldPassWord();
        String newPassWord = changePass.getNewPassWord();
        String confirmPassWord = changePass.getConfirmPassWord();

        if (oldPassWord == null || newPassWord == null || confirmPassWord == null) {
            throw new RuntimeException("Mật khẩu không được để trống");
        }

        if (!EncodeUtil.EncodeBase64PassWord(oldPassWord).equals(nhanVien.getPassWord())) {
            throw new RuntimeException("Mật khẩu cũ không đúng");
        }

        if (!newPassWord.equals(confirmPassWord)) {
            throw new RuntimeException("Mật khẩu không trùng khớp");
        }

        nhanVien.setPassWord(EncodeUtil.EncodeBase64PassWord(newPassWord));
        nhanVienRepository.save(nhanVien);
        return true;
    }





}
