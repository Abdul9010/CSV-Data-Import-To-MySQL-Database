package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

}
