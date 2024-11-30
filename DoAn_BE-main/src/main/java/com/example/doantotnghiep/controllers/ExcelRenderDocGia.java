package com.example.doantotnghiep.controllers;

import com.example.doantotnghiep.DTO.DocGiaDTO;
import com.example.doantotnghiep.DTO.NhanVienDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelRenderDocGia {
    public List<DocGiaDTO> readExcelFile(String filePath) throws IOException {
        List<DocGiaDTO> docGiaList = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Skip header row
            }

            DocGiaDTO docGiaDTO = new DocGiaDTO();
            docGiaDTO.setMaDocGia((long) getNumericCellValue(row.getCell(0)));
            docGiaDTO.setTenDocGia(getStringCellValue(row.getCell(1)));
            docGiaDTO.setGioiTinh(getStringCellValue(row.getCell(2)));
            docGiaDTO.setSoDienThoai(getStringCellValue(row.getCell(3)));
            docGiaDTO.setNamSinh((long) getNumericCellValue(row.getCell(4)));
            docGiaDTO.setEmail(getStringCellValue(row.getCell(5)));
            docGiaDTO.setUserName(getStringCellValue(row.getCell(6)));
            docGiaDTO.setPassWord(getStringCellValue(row.getCell(7)));
            docGiaDTO.setTrangThaiHoatDong((long) getNumericCellValue(row.getCell(8)));
            docGiaDTO.setMaVaiTro((long) getNumericCellValue(row.getCell(9)));

            docGiaList.add(docGiaDTO);
        }

        workbook.close();
        fileInputStream.close();

        return docGiaList;
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
