package com.alekkras.listOfItems.models;

import lombok.*;

import javax.persistence.*;
//

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Column(name = "author")
	private String author;
}
