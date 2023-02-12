package com.alekkras.listOfItems.controllers;

import com.alekkras.listOfItems.models.Item;
import com.alekkras.listOfItems.services.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ItemsController {
	private final ItemsService itemsService;

	@GetMapping("/")
	public String items(@RequestParam(name = "title", required = false) String title, Model model) {
		model.addAttribute("items", itemsService.listItems(title));
		return "items";
	}

	@GetMapping("/item/{id}")
	public String itemInfo(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemsService.getItemById(id));
		return "item-info";
	}

	@PostMapping("/item/create")
	public String createItem(Item Item) {
		itemsService.saveItem(Item);
		return "redirect:/";
	}

	@PostMapping("/item/delete/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemsService.deleteItem(id);
		return "redirect:/";
	}
}