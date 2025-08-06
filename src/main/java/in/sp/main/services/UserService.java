package in.sp.main.services;

import java.util.List;

import in.sp.main.entities.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService 
{
  public boolean registerUser(User user);
  public User loginUser(String email,String password);
  public List<User> getAllUsers();
  
  User getUserById(int id);
  void deleteUser(int id);
  
  void logout(HttpServletRequest request);
  
  
}
