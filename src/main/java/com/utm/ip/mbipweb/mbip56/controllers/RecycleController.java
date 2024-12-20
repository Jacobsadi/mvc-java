package com.utm.ip.mbipweb.mbip56.controllers;

import com.utm.ip.mbipweb.mbip56.models.recycle.Recycle;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleDAO;
import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.services.recycle.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/Recycle")
public class RecycleController {

    @Autowired
    private RecycleService recycleService;

    @GetMapping("/showRecycleForm")
    public String showRecycleForm(HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("user") == null) {
            redirectAttributes.addFlashAttribute("error", "You must be logged in to enter data");
            return "redirect:/"; // Redirect to the login page
        }
        return "forms/recycleForm"; // Assuming you have a separate form for recycling data
    }

    @PostMapping("/addRecycle")
    public String addRecycle(@RequestParam String userID, @RequestParam String dateRecorded,
            @RequestParam int RecycleUsage,
            Model model) {
        System.out.println("Received date: " + dateRecorded);
        int parsedUserID = Integer.parseInt(userID);
        LocalDate parsedDateRecorded = LocalDate.parse(dateRecorded);
        Recycle Recycle = new Recycle();
        Recycle.setUserID(parsedUserID);
        Recycle.setDateRecorded(parsedDateRecorded);
        Recycle.setRecycleUsage(RecycleUsage);
        Recycle savedRecycle = recycleService.addRecycle(Recycle);
        model.addAttribute("savedRecycle", savedRecycle);
        return "redirect:/user/home";
    }
}
