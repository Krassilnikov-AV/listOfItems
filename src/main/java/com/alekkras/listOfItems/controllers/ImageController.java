package com.alekkras.listOfItems.controllers;

import com.alekkras.listOfItems.models.Image;
import com.alekkras.listOfItems.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
	private final ImageRepository imageRepository;

	@GetMapping("/images/{id}")
	private ResponseEntity<?> getImageById(@PathVariable Long id) {
		Image image = imageRepository.findById(id).orElse(null);
		assert image != null;
		return ResponseEntity.ok()
			.header("fileName", image.getOriginalFileName())
			.contentType(MediaType.valueOf(image.getContentType()))
			.contentLength(image.getSize())
			.body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
	}
}