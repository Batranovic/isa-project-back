package com.example.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISAproject.model.RegisteredUser;

public interface RegisteredUserRepository  extends JpaRepository<RegisteredUser, Integer> {

}
