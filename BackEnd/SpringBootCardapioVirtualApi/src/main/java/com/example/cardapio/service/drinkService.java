package com.example.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.dto.DrinkRequestDTO;
import com.example.cardapio.dto.DrinkResponseDTO;
import com.example.cardapio.model.Drink;
import com.example.cardapio.repository.DrinkRepository;

@Service
public class drinkService {

	@Autowired
	private DrinkRepository repository;

	public List<DrinkResponseDTO> fetchDrinkList() {
		return repository.findAllDrinks();
	}

	public Drink saveDrink(DrinkRequestDTO drink) {

		Drink drinkEntity = new Drink(drink.title(), drink.image(), drink.price());
		
		return repository.save(drinkEntity);
	}

	public DrinkResponseDTO findDrinkByID(Long id) {

		DrinkResponseDTO drink = repository.findDrink(id);

		return drink;
	}
	
	public DrinkResponseDTO findDrinkByTitle(String title) {

		DrinkResponseDTO drink = repository.findDrinkByName(title);

		return drink;
	}
	
	public void deleteDrink(Long id) {
		repository.deleteById(id);
	}
	
	public Drink updateDrink(DrinkResponseDTO drink) {
		
		Drink drinkEntity = new Drink(drink.id(),drink.title(), drink.image(), drink.price());

		return repository.save(drinkEntity);
	}
	
	

}
