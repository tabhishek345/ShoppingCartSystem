package com.capgemini.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.UserProfile;

@ComponentScan(basePackages = "com.capgemini.service")
@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Integer> {

}
