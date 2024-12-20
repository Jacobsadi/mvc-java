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
import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.services.water.WaterService;

@Controller
@RequestMapping("/water")
public class WaterController {
    @Autowired
    private WaterService waterService;
    @Autowired
    private UserService userService;
    @GetMapping("/showWaterForm")
    public String showWaterForm(Model model) {
        User loggedInUser = (User) model.getAttribute("loggedInUser");
        System.out.println("Logged-in User: " + loggedInUser);
        model.addAttribute("loggedInUser", loggedInUser);
        return "forms/waterForm";
    }

    @PostMapping("/addWater")
    public String addWater(@RequestParam String userID, @RequestParam String dateRecorded, @RequestParam int waterUsage,
            Model model) {
        System.out.println("Received date: " + dateRecorded);
        int parsedUserID = Integer.parseInt(userID);
        LocalDate parsedDateRecorded = LocalDate.parse(dateRecorded);
        Water water = new Water();
        water.setUserID(parsedUserID);
        water.setDateRecorded(parsedDateRecorded);
        water.setWaterUsage(waterUsage);
        Water savedWater = waterService.addWater(water);
        model.addAttribute("savedWater", savedWater);
        return "redirect:/user/home";
    }
    // @RequestMapping("/admin/showdata")
    // public String showDetails(Model model) {
    //     List<User> users = userService.getAllUsers();
    //     for (User user : users) {
    //         if (waterService.doesUserIdExistInWater(user.getUserId())) {
    //             Water water = waterService.getWaterByUserId(user.getUserId());
    //             user.setUserWaterUsage(water);
    

    //         } else {
    //             System.out.println("No water data for user " + user.getUserId());
    //         }
    //     }
    //     model.addAttribute("users", users);
    
    //     return "admin/showPage";
    // }
}
