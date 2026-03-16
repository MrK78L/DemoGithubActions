package com.example.NguyenHoangPhuocLoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        // Truyền tên của bạn vào biến "name" để gửi sang file HTML
        model.addAttribute("name", "Nguyễn Hoàng Phước Lộc");

        // Trả về tên file giao diện (không cần đuôi .html)
        return "hello";
    }
}