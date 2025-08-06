package in.sp.main.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.controllerrepositories.UserRepository;
import in.sp.main.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean registerUser(User user) {

		try {
			userRepository.save(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public User loginUser(String email,String password) {
	  User validUser= userRepository.findByEmail(email);
	  
	  if(validUser != null && validUser.getPassword().equals(password))
	  {
		  return validUser;
	  }
	  
	  return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User getUserById(int id) {
		Optional<User> optionalUser=userRepository.findById(id);
		return optionalUser.orElse(null);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}


	public void logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	}
	
	


	
	
	
	

}
