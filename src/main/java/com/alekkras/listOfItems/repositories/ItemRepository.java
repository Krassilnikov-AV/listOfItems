package com.alekkras.listOfItems.repositories;

import com.alekkras.listOfItems.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByTitle(String title);
}
