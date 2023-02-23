package com.alekkras.listOfItems.controllers;

import com.alekkras.listOfItems.models.Item;
import com.alekkras.listOfItems.services.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ItemsController {
	private final ItemsService itemsService;


	@GetMapping("/")
	public String items(@RequestParam(name = "title", required = false) String title, Principal principal,
						Model model) {
		model.addAttribute("items", itemsService.listItems(title));
		model.addAttribute("user", itemsService.getUserByPrincipal(principal));
		return "items";
	}

	@GetMapping("/item/{id}")
	public String itemInfo(@PathVariable Long id, Model model) {
		Item item = itemsService.getItemById(id);
		model.addAttribute("item", item);
		model.addAttribute("images", item.getImages());
		return "item-info";
	}

	@PostMapping("/item/create")
	public String createItem(@RequestParam("file1") MultipartFile file1,
							 @RequestParam("file2") MultipartFile file2,
							 @RequestParam("file3") MultipartFile file3,
							 Item item, Principal principal) throws Exception {
		itemsService.saveItem(principal, item, file1, file2, file3);
		return "redirect:/";
	}

	@PostMapping("/item/delete/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemsService.deleteItem(id);
		return "redirect:/";
	}
}