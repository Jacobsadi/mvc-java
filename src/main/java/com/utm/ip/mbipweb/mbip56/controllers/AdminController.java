package com.utm.ip.mbipweb.mbip56.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping({ "", "/" })
    public String viewHome() {
        return "admin/home";

    }

    @GetMapping("/receiveddata")
    public String adminDashboard(@RequestParam(required = false) String section, Model model) {
        model.addAttribute("role", "admin");
        model.addAttribute("section", section);
        return "admin/details";
    }
    

}
