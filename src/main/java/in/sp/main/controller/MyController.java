package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/regPage")
	public String openRegPage(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/regform")
	public String submitRegForm(@ModelAttribute("user") User user,Model model)
	{
		boolean status=userService.registerUser(user);
		if(status)
		{
			model.addAttribute("successMsg","Registered Successfully");
		}
		else {
			model.addAttribute("ErrorMsg","Registeration not Successfully");
		}
		return "register";
		
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model)
	{
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/loginform")
	public String submitLoginForm(@ModelAttribute("user") User user,Model model,HttpServletRequest request)
	{
		User validUser=userService.loginUser(user.getEmail(), user.getPassword());
		
		if(validUser != null)
		{
			 HttpSession session = request.getSession();
		        session.setAttribute("userId", validUser.getId());
		        
		        session.setAttribute("userName", validUser.getName());

		        return "redirect:/user/dashboard";
		}
		else {
			model.addAttribute("ErrorMsg","Email and Password didn't Match");
			return "login";
		}
		
	}
	
	@GetMapping("/user/dashboard")
	public String userDashboard(HttpServletRequest request, Model model) {
	    HttpSession session = request.getSession(false);

	    if (session == null || session.getAttribute("userId") == null) {
	        return "redirect:/login";
	    }

	    int userId = (int) session.getAttribute("userId");
	    User user = userService.getUserById(userId); 

	    model.addAttribute("user", user);
	    return "user_dashboard"; 
	}

	
	

	
	
}
