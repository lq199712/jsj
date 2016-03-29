package com.lq.service;

import java.util.List;

import com.lq.po.User;

public interface IUserService {

	public void sayHello();

	public List<User> getUsers();

	public void add(User user);

	public void deleteById(int id);

	public User loadById(int id);

	public void update(User user);
}
