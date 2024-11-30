package com.example.doantotnghiep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication
public class DoAnTotNghiepApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoAnTotNghiepApplication.class, args);
    }


}
