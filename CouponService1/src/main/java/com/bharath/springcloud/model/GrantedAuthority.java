package com.bharath.springcloud.model;

public interface GrantedAuthority {

	long getId();

	void setId(long id);

	String getName();

	void setName(String name);

}