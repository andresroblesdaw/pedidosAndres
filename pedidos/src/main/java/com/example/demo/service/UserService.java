package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

@Service
public class UserService {

	private static ArrayList<User> usuarios = new ArrayList<>();

	public UserService() {


	}

	public User buscarUser(Long id) {

		for (User u : usuarios) {

			if (u.getId() == id) {

				return u;

			}

		}
		return null;
	}
	
	
	public User crearUser(User u) {
		
		
		usuarios.add(u);
		return u;
		
	}
	
	
	public boolean eliminarUser(Long id) {
		
		User us = buscarUser(id);
		
		return usuarios.remove(us);
		
	}

	

}
