package com.javalearning.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	int userCount = 3;
	
	static {
		users.add(new User(1, "Cole", new Date()));
		users.add(new User(2, "Andy", new Date()));
		users.add(new User(3, "Nhut", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public List<User> findAll(int from, int to){
		
		List<User> list = new ArrayList<User>();
		
		if (from >= 0) {
			int idx = from;
			while (idx <= to && idx < userCount) {
				
				list.add(users.get(idx));
				idx++;
			}
		}
		
		return list;
	}
	
	public User add(User user){
		if (user.getId() == null || user.getId() == 0) {
			userCount++;
			user.setId(userCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	
	public boolean delete(int id) {
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				return true;
			}
		}
		
		return false;
	}
}
