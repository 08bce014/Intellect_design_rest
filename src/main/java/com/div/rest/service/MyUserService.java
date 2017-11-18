package com.div.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.div.rest.model.User;

@Service
public class MyUserService {

	private MyUserService myService;

	private Map<String, User> userHash = new HashMap<>();

	public MyUserService getMyUserService() {
		if (myService == null)
			myService = new MyUserService();

		return myService;
	}

	public Map<String, User> getUserHash() {
		return userHash;
	}

	public void setUserHash(Map<String, User> userHash) {
		this.userHash = userHash;
	}
	
	public void createUser(User user)
	{
		if(!userHash.containsKey(user.getId()))
			userHash.put(user.getId(), user);
	}
	
	public void updateUser(User user)
	{
			userHash.put(user.getId(), user);
	}
	
	public void deleteUser(String userId)
	{
			userHash.remove(userId);
	}
	
	public User getUser(String userId)
	{
		if(userHash.containsKey(userId))
			return userHash.get(userId);
		else
			return null;
					
	}
}
