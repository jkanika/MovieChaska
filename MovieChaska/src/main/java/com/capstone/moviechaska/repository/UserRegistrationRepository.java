package com.capstone.moviechaska.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.moviechaska.entity.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long>{

}
