package com.ltw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltw.dao.UserDao;
import com.ltw.entity.User;
import com.ltw.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	/**
	 * save
	 */
	@Override
	/*public User save(User user) {
		user =userDao.save(user);
		return user;
	}*/
	//mybatis
	public User save(User user) {
		userDao.save(user);
		return user;
	}

	/**
	 * find
	 */
	@Override
	
	/*public User findById(int id) {
		User user =	userDao.findOne(id);
		return user;
	}*/
	//mybatis
	public User findById(int id) {
		User user =	userDao.findById(id);
		return user;
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}

}
