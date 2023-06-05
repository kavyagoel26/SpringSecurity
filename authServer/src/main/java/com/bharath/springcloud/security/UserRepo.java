package com.bharath.springcloud.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.springcloud.security.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	//finder method that will retrive the user details
	 User findByEmail(String email) ;


}
