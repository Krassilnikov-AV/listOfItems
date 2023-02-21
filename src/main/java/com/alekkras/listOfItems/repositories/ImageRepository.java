package com.alekkras.listOfItems.repositories;

import com.alekkras.listOfItems.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}