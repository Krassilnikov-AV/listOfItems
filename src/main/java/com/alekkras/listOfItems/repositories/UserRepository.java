package com.alekkras.listOfItems.repositories;


import com.alekkras.listOfItems.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}