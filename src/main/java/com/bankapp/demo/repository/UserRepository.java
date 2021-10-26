package com.bankapp.demo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bankapp.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//User findByUserName(String userName);
	
//	User findByEmail(String email);
	
	User findByPanNumber(String panNumber);
	
	Optional<User> findByMobileNumber(String mobileNumber);
	
	
	

}
