package com.exercise.countryservice.services;

import com.exercise.countryservice.domain.Country;
import reactor.core.publisher.Flux;

public interface CountryClientService {

	Flux<Country> getAllCountries();
	Flux<Country> getByName(String name);


}
