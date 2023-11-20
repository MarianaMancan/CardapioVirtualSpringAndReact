package com.example.cardapio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.dto.DrinkRequestDTO;
import com.example.cardapio.dto.DrinkResponseDTO;


import com.example.cardapio.repository.DrinkRepository;
import com.example.cardapio.model.Drink;
import com.example.cardapio.service.drinkService;

@RestController
@RequestMapping("drink")
public class DrinkController {

	@Autowired
	private drinkService service;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<DrinkResponseDTO> getAll() {
		List<DrinkResponseDTO> drinkList = service.fetchDrinkList();
		return drinkList;
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public Drink saveDrink(@RequestBody DrinkRequestDTO data) {

		return service.saveDrink(data);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get/{id}")
	public DrinkResponseDTO findDrinkByid(@PathVariable("id") Long id) {
		return service.findDrinkByID(id);
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/{title}")
	public DrinkResponseDTO findDrinkDrinkByTitle(@PathVariable("title")String title ) {
		return service.findDrinkByTitle(title);
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete/{id}")
	public String deleteDrinkById(@PathVariable("id") Long idLong) {
		service.deleteDrink(idLong);
		return "Deleted Successfully";
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/update")
	public Drink updateDrink(@RequestBody DrinkResponseDTO data) {

		return service.updateDrink(data);
	}

}
