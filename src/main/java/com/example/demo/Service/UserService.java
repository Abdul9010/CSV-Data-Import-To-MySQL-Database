package com.example.demo.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.User;

public interface UserService {

	boolean HasCSVFromar(MultipartFile file);
	
	void ProcessAndSaveData(MultipartFile file);
	
	public List<User>getAll();
}
