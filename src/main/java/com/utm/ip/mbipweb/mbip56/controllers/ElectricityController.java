package com.utm.ip.mbipweb.mbip56.controllers;
import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.services.user.UserService;
import com.utm.ip.mbipweb.mbip56.models.user.User;

import com.utm.ip.mbipweb.mbip56.models.electricity.Electricity;
import com.utm.ip.mbipweb.mbip56.services.electricity.ElectricityService;

@Controller
@RequestMapping("/electricity")
public class ElectricityController {
    @Autowired
    private ElectricityService electricityService;
    @Autowired
    private UserService userService;
    @GetMapping("/showElectricityForm")
    public String showElectricityForm(Model model) {
        User loggedInUser = (User) model.getAttribute("loggedInUser");
        System.out.println("Logged-in User: " + loggedInUser);
        model.addAttribute("loggedInUser", loggedInUser);
        return "forms/ElectricityForm";
    }

    @PostMapping("/addelectricity")
    public String addElectricity(@RequestParam String userID, @RequestParam String dateRecorded, @RequestParam float electricityUsage,
            Model model) {
        System.out.println("Received date: " + dateRecorded);
        int parsedUserID = Integer.parseInt(userID);
        LocalDate parsedDateRecorded = LocalDate.parse(dateRecorded);
        Electricity electricity = new Electricity();
        electricity.setUserID(parsedUserID);
        electricity.setDateRecorded(parsedDateRecorded);
        electricity.setElectricityUsage(electricityUsage);
        System.out.println("The usage is -----------: " + electricity.getElectricityUsage());
        System.out.println("The Date is -----------: " + electricity.getDateRecorded());
        Electricity savedElectricity = electricityService.addElectricity(electricity);
        model.addAttribute("savedElectricity", savedElectricity);
        return "redirect:/user/home";
    }

}
