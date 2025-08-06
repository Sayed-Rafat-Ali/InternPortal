package in.sp.main.controllerrepositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	List<User> findAll();
	 
}
