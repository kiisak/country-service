package com.exercise.countryservice.controllers;

import com.exercise.countryservice.domain.Country;
import com.exercise.countryservice.services.CountryClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {

	private CountryClientService countryClientService;

	public CountryController(CountryClientService countryClientService) {
		this.countryClientService = countryClientService;
	}

	@GetMapping("/countries")
	Flux<Country> list(){
		return countryClientService.getAllCountries();
	}

	@GetMapping("/countries/name/{name}")
	Flux<Country> findByName(@PathVariable String name){
		return countryClientService.getByName(name);
	}
}
