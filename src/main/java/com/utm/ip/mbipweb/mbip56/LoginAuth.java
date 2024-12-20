package com.utm.ip.mbipweb.mbip56;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.services.user.UserService;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("loggedInUser")
public class LoginAuth {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {

        User authenticatedUser = userService.authenticateUser(username, password);

        if ((authenticatedUser != null) && (authenticatedUser.getRole())) {
            model.addAttribute("loggedInUser", authenticatedUser);
            // model.addAttribute("user", authenticatedUser);
            return "admin/home";
        } else if ((authenticatedUser != null) && (authenticatedUser.getRole() == false)) {
            model.addAttribute("loggedInUser", authenticatedUser);
            // model.addAttribute("user", authenticatedUser);

            return "user/home";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "AccountAccess/login";
        }
    }
}
