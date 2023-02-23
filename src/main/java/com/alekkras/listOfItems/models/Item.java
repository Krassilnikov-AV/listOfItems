package com.alekkras.listOfItems.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "itm")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description", columnDefinition = "text")
	private String description;
	@Column(name = "price")
	private int price;
	@Column(name = "city")
	private String city;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
		mappedBy = "item")
	private List<Image> images = new ArrayList<>();
	private Long prewiewImageId;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	private LocalDateTime dateOfCreated;

	@PrePersist
	private void init() {
		dateOfCreated = LocalDateTime.now();
	}

	public void addImageToItem(Image image) {
		image.setItem(this);
		images.add(image);
	}
}