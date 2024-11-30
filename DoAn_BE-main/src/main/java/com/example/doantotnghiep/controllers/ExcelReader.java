package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.NhanVienDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public List<NhanVienDTO> readExcelFile(String filePath) throws IOException {
        List<NhanVienDTO> nhanVienList = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Skip header row
            }

            NhanVienDTO nhanVien = new NhanVienDTO();
            nhanVien.setMaNV((long) getNumericCellValue(row.getCell(0)));
            nhanVien.setTenNV(getStringCellValue(row.getCell(1)));
            nhanVien.setGioiTinh(getStringCellValue(row.getCell(2)));
            nhanVien.setSoDienThoai(getStringCellValue(row.getCell(3)));
            nhanVien.setNamSinh((long) getNumericCellValue(row.getCell(4)));
            nhanVien.setEmail(getStringCellValue(row.getCell(5)));
            nhanVien.setUserName(getStringCellValue(row.getCell(6)));
            nhanVien.setPassWord(getStringCellValue(row.getCell(7)));
            nhanVien.setTrangThaiHoatDong((long) getNumericCellValue(row.getCell(8)));
            nhanVien.setMaPhongBan((long) getNumericCellValue(row.getCell(9)));
            nhanVien.setMaVaiTro((long) getNumericCellValue(row.getCell(10)));

            nhanVienList.add(nhanVien);
        }

        workbook.close();
        fileInputStream.close();

        return nhanVienList;
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.FORMULA) {
            return cell.getCellFormula();
        }
        return null;
    }

    private double getNumericCellValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            try {
                return Double.parseDouble(cell.getStringCellValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
