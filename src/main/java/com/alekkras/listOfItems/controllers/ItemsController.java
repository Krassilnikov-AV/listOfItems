package com.alekkras.listOfItems.controllers;


import com.alekkras.listOfItems.models.*;
import com.alekkras.listOfItems.services.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ItemsController {
	private final ItemsService itemsService;

	@GetMapping("/")
	public String items(@RequestParam(name = "searchWord", required = false) String title, Principal principal,
						Model model) {
		model.addAttribute("items", itemsService.listItems(title));
		model.addAttribute("user", itemsService.getUserByPrincipal(principal));
		model.addAttribute("searchWord", title);
		return "items";
	}

	@GetMapping("/item/{id}")
	public String itemInfo(@PathVariable Long id, Model model, Principal principal) {
		Item item = itemsService.getItemById(id);
		model.addAttribute("user", itemsService.getUserByPrincipal(principal));
		model.addAttribute("item", item);
		model.addAttribute("images", item.getImages());
		model.addAttribute("authorProduct", item.getUser());
		return "item-info";
	}

	@PostMapping("/item/create")
	public String creatItem(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
							@RequestParam("file3") MultipartFile file3, Item item, Principal principal) throws IOException {
		itemsService.saveItem(principal, item, file1, file2, file3);
		return "redirect:/my/items";
	}


	@PostMapping("/item/delete/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemsService.deleteItem(id);
		return "redirect:/";
	}

	@GetMapping("/my/items")
	public String userItems(Principal principal, Model model) {
		User user = itemsService.getUserByPrincipal(principal);
		model.addAttribute("user", user);
		model.addAttribute("items", user.getItems());
		return "my-items";
	}

}