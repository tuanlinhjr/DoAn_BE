package com.example.doantotnghiep.services.sach;

import com.example.doantotnghiep.DTO.SachDTO;
import com.example.doantotnghiep.models.*;
import com.example.doantotnghiep.repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SachService implements ISachService{

    @Autowired
    private ISachRepository sachRepository;

    @Autowired
    private INhaXuatBanRepository nhaXuatBanRepository;

    @Autowired
    private INgonNguRepository ngonNguRepository;
    @Autowired
    private ITacGiaRepository tacGiaRepository;
    @Autowired
    private ITheLoaiRepository theLoaiRepository;

    private static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/image/sach/";



//    @Override
//    public SachDTO addSach(SachDTO sachDTO) {
//        try {
//            if (sachRepository.existsByTenSach(sachDTO.getTenSach())) {
//                throw new IllegalArgumentException("Tên sách này đã tồn tại");
//            }
//            Sach sach = new Sach();
//            sach.setTenSach(sachDTO.getTenSach());
//            sach.setAnhBia(sachDTO.getAnhBia());
//            sach.setTinhTrang(sachDTO.getTinhTrang());
//            sach.setGiaBia(sachDTO.getGiaBia());
//            sach.setNamXuatBan(sachDTO.getNamXuatBan());
//            NhaXuatBan nhaXuatBan = nhaXuatBanRepository.findById(sachDTO.getMaNxb())
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà xuất bản có mã là: " + sachDTO.getMaNxb()));
//            sach.setNhaXuatBan(nhaXuatBan);
//            NgonNgu ngonNgu = ngonNguRepository.findById(sachDTO.getMaNgonNgu())
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy ngôn ngữ có mã là: " + sachDTO.getMaNgonNgu()));
//            sach.setNgonNgu(ngonNgu);
//            TacGia tacGia = tacGiaRepository.findById(sachDTO.getMaTacGia())
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả có mã là: " + sachDTO.getMaTacGia()));
//            sach.setTacGia(tacGia);
//            TheLoai theLoai = theLoaiRepository.findById(sachDTO.getMaTheLoai())
//                    .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại có mã là: " + sachDTO.getMaTheLoai()));
//            sach.setTheLoai(theLoai);
//
//
//            return SachDTO.fromEntity(sachRepository.save(sach));
//        } catch (IllegalArgumentException e) {
//            throw e;
//        } catch (Exception e) {
//            throw new RuntimeException("Đã xảy ra lỗi khi thêm sách", e);
//        }
//    }

    @Override
    public SachDTO addSach(SachDTO sachDTO) {

        return null;
    }

    @Override
    public boolean addSach(SachDTO sachDTO, HttpServletRequest request) {
        try{
            String originalFilename = sachDTO.getAnhBia().getOriginalFilename();

            String randomID = UUID.randomUUID().toString();
            String fileNameWithExtension = randomID + originalFilename.substring(originalFilename.lastIndexOf("."));

            String filePath = uploadDirectory + File.separator + fileNameWithExtension;
            Sach sach = new Sach();
            String imageUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + "/image/sach/" + fileNameWithExtension;
            sach.setTenSach(sachDTO.getTenSach());
            sach.setAnhBia(imageUrl);
            sach.setTinhTrang(sachDTO.getTinhTrang());
            sach.setGiaBia(sachDTO.getGiaBia());
            sach.setNamXuatBan(sachDTO.getNamXuatBan());
            NhaXuatBan nhaXuatBan = nhaXuatBanRepository.findById(sachDTO.getMaNxb())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà xuất bản có mã là: " + sachDTO.getMaNxb()));
            sach.setNhaXuatBan(nhaXuatBan);
            NgonNgu ngonNgu = ngonNguRepository.findById(sachDTO.getMaNgonNgu())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy ngôn ngữ có mã là: " + sachDTO.getMaNgonNgu()));
            sach.setNgonNgu(ngonNgu);
            TacGia tacGia = tacGiaRepository.findById(sachDTO.getMaTacGia())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả có mã là: " + sachDTO.getMaTacGia()));
            sach.setTacGia(tacGia);
            TheLoai theLoai = theLoaiRepository.findById(sachDTO.getMaTheLoai())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại có mã là: " + sachDTO.getMaTheLoai()));
            sach.setTheLoai(theLoai);
            SachDTO.fromEntity(sachRepository.save(sach));

            File folder = new File(uploadDirectory);
            if (!folder.exists()) {
                folder.mkdir();
            }
            // Copy file
            Files.copy(sachDTO.getAnhBia().getInputStream(), Paths.get(filePath));
            System.gc();  //or
            //folder.delete();
            return true;
        }catch (IOException e){

//            log.error(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean updateSach(Long maSach, SachDTO sachDetails, HttpServletRequest request) {
        try {
//            if (sachRepository.existsByTenSach(sachDetails.getTenSach())) {
//                throw new IllegalArgumentException("Tên sách này đã tồn tại");
//            }


            String originalFilename = sachDetails.getAnhBia().getOriginalFilename();
            String randomID = UUID.randomUUID().toString();
            String fileNameWithExtension = randomID + originalFilename.substring(originalFilename.lastIndexOf("."));
            String filePath = uploadDirectory + File.separator + fileNameWithExtension;
            Sach sach = sachRepository.findById(maSach)
                    .orElseThrow(()-> new RuntimeException("Không tìm thấy sách có mã là: " + maSach));
            String imageUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + "/image/sach/" + fileNameWithExtension;
            sach.setTenSach(sachDetails.getTenSach());
            sach.setAnhBia(imageUrl);
            sach.setTinhTrang(sachDetails.getTinhTrang());
            sach.setGiaBia(sachDetails.getGiaBia());
            sach.setNamXuatBan(sachDetails.getNamXuatBan());
            NhaXuatBan nhaXuatBan = nhaXuatBanRepository.findById(sachDetails.getMaNxb())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà xuất bản có mã là: " + sachDetails.getMaNxb()));
            sach.setNhaXuatBan(nhaXuatBan);
            NgonNgu ngonNgu = ngonNguRepository.findById(sachDetails.getMaNgonNgu())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy ngôn ngữ có mã là: " + sachDetails.getMaNgonNgu()));
            sach.setNgonNgu(ngonNgu);
            TacGia tacGia = tacGiaRepository.findById(sachDetails.getMaTacGia())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả có mã là: " + sachDetails.getMaTacGia()));
            sach.setTacGia(tacGia);
            TheLoai theLoai = theLoaiRepository.findById(sachDetails.getMaTheLoai())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại có mã là: " + sachDetails.getMaTheLoai()));
            sach.setTheLoai(theLoai);
            SachDTO.fromEntity(sachRepository.save(sach));

            File folder = new File(uploadDirectory);
            if (!folder.exists()) {
                folder.mkdir();
            }
            // Copy file
            Files.copy(sachDetails.getAnhBia().getInputStream(), Paths.get(filePath));
            System.gc();  //or
            //folder.delete();
            return true;
        }catch (IOException e){

//            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public void deleteSach(Long maSach) {

    }

    @Override
    public Optional<Sach> findById(Long maSach) {
//        return sachRepository.findById(maSach)
//                .stream().findFirst().map(SachDTO::fromEntity);
        return sachRepository.findById(maSach);
    }

    @Override
    public List<Sach> getAll() {
//        return sachRepository.findAll()
//                .stream().map(SachDTO::fromEntity).collect(Collectors.toList());
        return sachRepository.findAll();
    }

    @Override
    public List<Sach> findSachByMaTL(Long maTheLoai) {
        return sachRepository.findByTheLoai_MaTheLoai(maTheLoai);
    }


}
