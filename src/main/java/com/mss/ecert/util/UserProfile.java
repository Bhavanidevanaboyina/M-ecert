package com.mss.ecert.util;

import java.util.Optional;
import java.util.UUID;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mss.ecert.domain.User;
import com.mss.ecert.repository.UserRepository;



@Component
public class UserProfile {
	
	private User user;

	  @Autowired
	  public UserProfile(User user) {
	    this.user = user;
	  }
	
	
	@Autowired
	UserRepository userRepository;

	public void storeUserInformation(JSONObject jsonObject) {
		String userName = jsonObject.getString("loginId");
		
		  Optional<User> existingUser = userRepository.findByUserName(userName);

		    if (existingUser.isPresent()) {
		        // user already exists in the database, do not save
		        return;
		    }
		// TODO Auto-generated method stub
		//int id=jsonObject.getInt("empId");
		String name=jsonObject.getString("firstName")+" "+jsonObject.getString("middleName")+" "+jsonObject.getString("lastName");
		user.setUserId(UUID.randomUUID().toString());
		user.setHubbleId(jsonObject.getInt("empNo"));
		user.setUserName(jsonObject.getString("loginId"));
		user.setGender(jsonObject.getString("gender"));
		user.setFullName(name);
		userRepository.save(user);
	}
	
	

}
