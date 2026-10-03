package com.example.plantio1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.plantio1.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
