package in.sp.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

	// hardcoded admin credentials
	
    private final String ADMIN_EMAIL = "admin@gmail.com";
    private final String ADMIN_PASSWORD = "admin123";
    
    @GetMapping("/admin")
    public String adminLoginPage() {
        return "adminLogin"; // loads adminLogin.html
    }

    @PostMapping("/admin/login")
    public String adminLogin(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
            return "redirect:/admin_dashboard";
        } else {
            model.addAttribute("error", "Only admin can open this.");
            return "adminLogin";
        }
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin_dashboard"; // make sure you have this file in templates
    }
    
    


}
