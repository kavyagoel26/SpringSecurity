package com.bharath.springcloud.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.springcloud.security.*;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
