package com.example.doantotnghiep.DTO;

import com.example.doantotnghiep.models.ChiTietHDN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePass {
    private Long maNV;
    private String oldPassWord;
    private String newPassWord;
    private String confirmPassWord;


}
