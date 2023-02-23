package com.alekkras.listOfItems.controllers;

import com.alekkras.listOfItems.models.User;
import com.alekkras.listOfItems.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}


	@PostMapping("/registration")
	public String createUser(User user, Model model) {
		if (!userService.createUser(user)) {
			model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
			return "registration";
		}
		return "redirect:/login";
	}

	@GetMapping("/hello")
	public String securityUrl() {
		return "hello";
	}
}