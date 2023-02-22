package com.alekkras.listOfItems.services;

import com.alekkras.listOfItems.models.User;
import com.alekkras.listOfItems.models.enums.Role;
import com.alekkras.listOfItems.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public boolean createUser(User user) {
		String userEmail = user.getEmail();
		if (userRepository.findByEmail(userEmail) != null) return false;
		user.setActive(true);
		user.getRoles().add(Role.ROLE_USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		log.info("Saving new User with email: {}", userEmail);
		userRepository.save(user);
		return true;
	}
}