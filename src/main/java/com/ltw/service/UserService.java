package com.ltw.service;

import java.util.List;

import com.ltw.entity.User;

public interface UserService {
	//jpa
 /* public User save(User user);
  public User findById(int id);*/
	//mybatis

 public User findById(int id);
 public List<User> findAll();

 public User save(User user);
}
