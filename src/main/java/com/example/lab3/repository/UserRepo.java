package com.example.lab3.repository;

import com.example.lab3.Domain.Uni_Directinal.JoinTable.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<User,Integer> {
}
