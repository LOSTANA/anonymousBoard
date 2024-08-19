package com.tenco.board.service;

import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class UserService {

	
	String name = null;
	public String createUser() {
		
		
		
		Random rd = new Random();

		name = "유저" + rd.nextInt(10000);
		
		
		return name;
	}
	
	
}
