package com.alekkras.listOfItems.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "imags")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "original_file_name")
	private String originalFileName;
	@Column(name = "size")
	private Long size;
	@Column(name = "content_type")
	private String contentType;
	@Column(name = "is_preview_image")
	private boolean isPreviewImage;
	@Lob
//	@Type(type = "org.hibernate.type.ImageType")
//	@Column(name = "bytes", columnDefinition = "BLOB NOT NULL")
	private byte[] bytes;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Item item;
}