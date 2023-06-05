package com.bharath.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.springcloud.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	//finder method that will retrive the user details
	 User findByEmail(String email) ;


}
