package com.developer.angularjs_oracle.dao;

import com.developer.angularjs_oracle.dto.User;


public interface UserDao {

	void add(User user);
	User getByParam(String param,String value);
}
