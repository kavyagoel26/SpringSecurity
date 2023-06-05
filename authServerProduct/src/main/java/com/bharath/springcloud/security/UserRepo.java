package com.bharath.springcloud.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	//finder method that will retrive the user details
	 User findByEmail(String email) ;


}
