package com.alekkras.listOfItems.services;

import com.alekkras.listOfItems.models.*;
import com.alekkras.listOfItems.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ItemsService {
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;


	public List<Item> listItems(String title) {
		if (title != null) return itemRepository.findByTitle(title);
		return itemRepository.findAll();
	}

	public void saveItem(Principal principal, Item item, MultipartFile file1, MultipartFile file2,
						 MultipartFile file3) throws IOException {
		item.setUser(getUserByPrincipal(principal));
		Image image1;
		Image image2;
		Image image3;
		if (file1.getSize() != 0) {
			image1 = toImageEntity(file1);
			image1.setPreviewImage(true);
			item.addImageToItem(image1);
		}
		if (file2.getSize() != 0) {
			image2 = toImageEntity(file2);
			item.addImageToItem(image2);
		}
		if (file3.getSize() != 0) {
			image3 = toImageEntity(file3);
			item.addImageToItem(image3);
		}
		log.info("Saving new Item. Title: {}; Author email: {}", item.getTitle(), item.getUser().getEmail());
		Item itemFromDb = itemRepository.save(item);
		itemFromDb.setPreviewImageId(itemFromDb.getImages().get(0).getId());
		itemRepository.save(item);
	}

	public User getUserByPrincipal(Principal principal) {
		if (principal == null) return new User();
		return userRepository.findByEmail(principal.getName());
	}


	private Image toImageEntity(MultipartFile file) throws IOException {
		Image image = new Image();
		image.setName(file.getName());
		image.setOriginalFileName(file.getOriginalFilename());
		image.setContentType(file.getContentType());
		image.setSize(file.getSize());
		image.setBytes(file.getBytes());
		return image;
	}

	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}

	public Item getItemById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}
}

