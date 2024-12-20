package com.utm.ip.mbipweb.mbip56.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.utm.ip.mbipweb.mbip56.models.electricity.Electricity;
import com.utm.ip.mbipweb.mbip56.models.recycle.Recycle;
import com.utm.ip.mbipweb.mbip56.services.electricity.*;
import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.models.water.*;
import com.utm.ip.mbipweb.mbip56.services.user.UserService;
import com.utm.ip.mbipweb.mbip56.services.water.WaterService;
import com.utm.ip.mbipweb.mbip56.services.recycle.RecycleService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WaterService waterService;
    @Autowired
    private ElectricityService electricityService;
    @Autowired
    private RecycleService recycleService;

    @RequestMapping("/regist")
    public String register(Model model) {
        model.addAttribute("mode", "add");
        return "AccountAccess/register";
    }

    @RequestMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/formEditUser")
    public String viewEditForm(@RequestParam String id, Model model) {
        // Retrieve the user by its ID
        User user = userService.getUserById(id);
        
        // Add the user and the mode (edit) to the model
        model.addAttribute("user", user);
        model.addAttribute("mode", "edit");
        
        // Return the view for the edit form
        return "AccountAccess/register";
    }
    @RequestMapping("/editUser")
    public String editUser(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String contact,
                           @RequestParam String area) {
        // Create a new User object with the provided parameters
        User user = new User(username, email, password, contact, area);
    
        // Call the service method to update the user
        userService.updateUser(user);
    
        // Redirect to the user's home page after editing
        return "redirect:/user/home";
    }
    

    


    @GetMapping("/home")
    public String userHome() {
        return "user/home"; // Assuming "user/home.jsp" exists
    }



    @RequestMapping("/admin/showdata")
    public String showDetails(Model model) {
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println("User: " + user.getUsername());

            if (waterService.doesUserIdExistInWater(user.getUserId())) {
                // Water water = waterService.getWaterByUserId(user.getUserId());
                List<Water> waterList = waterService.getWaterForUserId(user.getUserId());
                // user.setUserWaterUsage(water);

                user.setWaterList(waterList);

            } else {
                System.out.println("No water data for user " + user.getUserId());
                Water wa = new Water();
                wa.setWaterUsage(0);
                user.setUserWaterUsage(wa);
            }

            if (electricityService.doesUserIdExistInElectricity(user.getUserId())) { 
                // WHENE YOU COMMENT THIS PART OR MAKE MORE FORMS OF ELECTRICITY FOR ONE USE THE 
                // CODE WILL NOT RUN
                //  Electricity electricity = electricityService.getElectricityByUserId(user.getUserId());
                         Electricity electric = new Electricity();
                         LocalDate date = LocalDate.of(2024, 2, 7);
                         electric.setDateRecorded(date);
                         electric.setElectricityUsage(2311);
                        user.setUserElectricity(electric); 
                //*********************************************************** */
                //*********************************************************** */



                //
                List<Electricity> electricities = electricityService.getElectricityForId(user.getUserId());
                System.out.println("Electricities ElectricitiesElectricitiesElectricitiesElectricitiesElectricities for user " + user.getUserId() + ":");
                for (Electricity el : electricities) {
                    System.out.println("Electricity Usage: " + el.getElectricityUsage());
                    System.out.println("Electricity Usage: " + el.getElectricityID());
                    System.out.println("Electricity Usage: " + el.getUserID());
                    // Print other properties if needed
                user.setElectricityList(electricities);}

                System.out.println("Electricity LIST LIST LIST LIST : " + user.getElectricityList());



            } else {
                System.out.println("No electricity data for user " + user.getUserId());
                Electricity el = new Electricity();
                el.setElectricityUsage(0);
                user.setUserElectricity(el); 

            }

            if (recycleService.doesUserIdExistInRecycle(user.getUserId())) { 

                Recycle recycle = recycleService.getRecycleByUserId(user.getUserId());
                user.setUserRecycle(recycle); 
                System.out.println("No rNo rNo rNo rNo rNo recycle data for user-------------------------> " + user.getRecycleUsage());

            } else {
                System.out.println("No recycle data for user-------------------------> " + user.getUserId());
                Recycle re = new Recycle();
                re.setRecycleUsage(0);
                user.setUserRecycle(re); 

            }

        }
        model.addAttribute("users", users);

        return "admin/showPage";
    }

    @RequestMapping("/admin/showall")
    public String showAllData(Model model) {
        List<User> users = userService.getAllUsers();

        double totalWater = 0;
        double totalEnergy = 0;
        double totalRecycle = 0;
        
        for (User user : users) {
            if (waterService.doesUserIdExistInWater(user.getUserId())) {
                Water water = waterService.getWaterByUserId(user.getUserId());
                List<Water> waterList = waterService.getWaterForUserId(user.getUserId());
                // user.setUserWaterUsage(water);

                user.setWaterList(waterList);
                if (water != null) { // Check if the water object is not null
                    totalWater += water.getWaterUsage();
                }
            }

            // Repeat for electricity and recycle
            try {
                Electricity electricity = electricityService.getElectricityByUserId(user.getUserId());
                if (electricity != null) { // Check if the electricity object is not null
                    totalEnergy += electricity.getElectricityUsage();
                }
            } catch (NullPointerException e) {
                System.out.println("No electricity data for user " + user.getUserId());
                // Handle the null case here, for example, by continuing to the next user
                continue;
            }

            try {
                Recycle recycle = recycleService.getRecycleByUserId(user.getUserId());
                if (recycle != null) { // Check if the recycle object is not null
                    totalRecycle += recycle.getRecycleUsage();
                }
            } catch (NullPointerException e) {
                System.out.println("No recycle data for user " + user.getUserId());
                // Handle the null case here
                continue;
            }
        }

        // Now add the totals to the model
        model.addAttribute("totalWater", totalWater);
        model.addAttribute("totalEnergy", totalEnergy);
        model.addAttribute("totalRecycle", totalRecycle);

        return "admin/showAll"; // Assuming you store your JSPs in a folder named 'admin' under 'WEB-INF/views/'
    }

}
