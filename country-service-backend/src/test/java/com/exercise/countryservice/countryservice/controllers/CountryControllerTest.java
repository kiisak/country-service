package com.exercise.countryservice.countryservice.controllers;

import com.exercise.countryservice.controllers.CountryController;
import com.exercise.countryservice.domain.Country;
import com.exercise.countryservice.services.CountryClientService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static com.exercise.countryservice.helpers.testdata.COUNTRY_FI;
import static com.exercise.countryservice.helpers.testdata.COUNTRY_FR;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class CountryControllerTest {

	WebTestClient webTestClient;
	CountryClientService countryClientService;
	CountryController countryController;

	@Before
	public void setUp() {
		countryClientService = Mockito.mock(CountryClientService.class);
		countryController = new CountryController(countryClientService);
		webTestClient = WebTestClient.bindToController(countryController).build();
	}

	@Test
	public void getAllCountries_shouldReturnCountries() {
		List<Country> countries = new ArrayList<>();

		countries.add(new Country());
		given(countryClientService.getAllCountries())
				.willReturn(Flux.just(COUNTRY_FI, COUNTRY_FR));

		webTestClient.get()
				.uri("/countries")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Country.class)
				.hasSize(2);
	}

	@Test
	public void getAllCountries_shouldNotReturnCountries() {
		List<Country> countries = new ArrayList<>();

		countries.add(new Country());
		given(countryClientService.getAllCountries())
				.willReturn(Flux.empty());

		webTestClient.get()
				.uri("/countries")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Country.class)
				.hasSize(0);
	}

	@Test
	public void getByName_shouldReturnCountry() {
		given(countryClientService.getByName(anyString()))
				.willReturn(Flux.just(COUNTRY_FR));

		webTestClient.get()
				.uri("/countries/name/someCountry")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Country.class);
	}

	@Test
	public void getByName_shouldNotReturnCountry() {
		given(countryClientService.getByName(anyString()))
				.willReturn(Flux.empty());

		webTestClient.get()
				.uri("/countries/name/someCountry")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Country.class)
				.hasSize(0);
	}
}