package com.alekkras.listOfItems.services;

import com.alekkras.listOfItems.models.Item;
import com.alekkras.listOfItems.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemsService {

	private final ItemRepository itemRepository;

	public List<Item> listItems(String title) {
		if (title != null) return itemRepository.findByTitle(title);
		return itemRepository.findAll();
	}

	public void saveItem(Item item) {
		log.info("Saving new {}", item);
		itemRepository.save(item);
	}

	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}

	public Item getItemById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}
}