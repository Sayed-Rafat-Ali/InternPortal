package in.sp.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    //Show Admin Dashboard
    
    @GetMapping("/admin_dashboard")
    public String openAdminDashboard(Model model) {
    	
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        model.addAttribute("totalRegistrations", allUsers.size());
        return "admin_dashboard"; 
    }

    // View user details (dummy view page or console)
    @GetMapping("/admin/view/{id}")
    public String viewUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    // Delete user
    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, HttpSession session) {
        userService.deleteUser(id);
        session.setAttribute("message", "User deleted successfully!");
        return "redirect:/admin_dashboard";
    }
    
    @GetMapping("/logout")
    public String logOutUser(HttpSession session) {
        session.invalidate(); // clears all session data
        return "redirect:/";  // redirects to homepage
    }

    
    }


