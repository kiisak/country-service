package com.exercise.countryservice.services;

import com.exercise.countryservice.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CountryClientServiceImpl implements CountryClientService {

	private WebClient webClient;

	public static String API_BASE_URL = "https://restcountries.eu/rest/v2";

	public CountryClientServiceImpl() {
		this.webClient = WebClient.builder()
				.baseUrl(API_BASE_URL)
				.build();
	}

	public CountryClientServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	public CountryClientServiceImpl(String url) {
		this.webClient = WebClient.builder()
				.baseUrl(url)
				.build();
	}

	@Override
	public Flux<Country> getAllCountries() {
		return webClient.get()
				.uri(API_BASE_URL + "/all")
				.retrieve()
				.bodyToFlux(Country.class);
	}

	@Override
	public Flux<Country> getByName(String name) {
		return webClient.get()
				.uri(API_BASE_URL + "/name/" + name)
				.retrieve()
				.bodyToFlux(Country.class);
	}
}
