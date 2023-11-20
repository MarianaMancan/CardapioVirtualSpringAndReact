package com.example.cardapio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cardapio.dto.DrinkResponseDTO;
import com.example.cardapio.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink,Long> {

	@Query("SELECT new com.example.cardapio.dto.DrinkResponseDTO( d.id, d.title, d.image, d.price) FROM Drink d")
    List<DrinkResponseDTO> findAllDrinks();
	
	@Query("SELECT new com.example.cardapio.dto.DrinkResponseDTO( d.id, d.title,d.image, d.price) FROM Drink d WHERE d.id = :id")
	DrinkResponseDTO findDrink(@Param("id") long id);
	
	@Query("SELECT new com.example.cardapio.dto.DrinkResponseDTO( d.id, d.title,d.image, d.price) FROM Drink d WHERE d.title = :title")
	DrinkResponseDTO findDrinkByName(@Param("title") String title);

	
}