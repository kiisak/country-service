package com.exercise.countryservice.services;

import com.exercise.countryservice.domain.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import org.mockito.Mock;
import reactor.test.StepVerifier;

import static com.exercise.countryservice.helpers.testdata.*;
import static com.exercise.countryservice.services.CountryClientServiceImpl.API_BASE_URL;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CountryClientServiceImplTest {

	private CountryClientService countryClientService;

	@Mock
	private WebClient webClientMock;

	@Mock
	private WebClient.RequestHeadersSpec requestHeadersMock;

	@Mock
	private WebClient.RequestHeadersUriSpec requestHeadersUriMock;

	@Mock
	private WebClient.ResponseSpec responseMock;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		countryClientService = new CountryClientServiceImpl(webClientMock);
	}

	@Test
	public void getAllCountries_shouldReturnCountries() {
		when(webClientMock.get()).thenReturn(requestHeadersUriMock);
		when(requestHeadersUriMock.uri(API_BASE_URL+ "/all")).thenReturn(requestHeadersMock);
		when(requestHeadersMock.retrieve()).thenReturn(responseMock);
		when(responseMock.bodyToFlux(Country.class)).thenReturn(Flux.just(COUNTRY_FI, COUNTRY_FR));

		Flux<Country> countries = countryClientService.getAllCountries();
		assertEquals(countries.collectList().block().size(), 2);

		StepVerifier
				.create(countries)
				.expectNextMatches(country -> country.getAlpha2Code().equals(COUNTRY_CODE_FI)
						&& country.getCapital().equals(COUNTRY_CAPITAL_FI)
						&& country.getFlag().equals(COUNTRY_FLAG_URL_FI)
						&& country.getName().equals(COUNTRY_NAME_FI)
						&& country.getPopulation().equals(COUNTRY_POPULATION_FI))
				.expectNextMatches(country -> country.getAlpha2Code().equals(COUNTRY_CODE_FR)
						&& country.getCapital().equals(COUNTRY_CAPITAL_FR)
						&& country.getFlag().equals(COUNTRY_FLAG_URL_FR)
						&& country.getName().equals(COUNTRY_NAME_FR)
						&& country.getPopulation().equals(COUNTRY_POPULATION_FR))
				.expectComplete()
				.verify();
	}

	@Test
	public void getAllCountries_shouldNotReturnCountries() {
		when(webClientMock.get()).thenReturn(requestHeadersUriMock);
		when(requestHeadersUriMock.uri(API_BASE_URL+ "/all")).thenReturn(requestHeadersMock);
		when(requestHeadersMock.retrieve()).thenReturn(responseMock);
		when(responseMock.bodyToFlux(Country.class)).thenReturn(Flux.empty());

		Flux<Country> countries = countryClientService.getAllCountries();
		StepVerifier
				.create(countries)
				.expectNextCount(0)
				.expectComplete()
				.verify();

	}

	@Test
	public void getByName_shouldReturnCountry() {
		when(webClientMock.get()).thenReturn(requestHeadersUriMock);
		when(requestHeadersUriMock.uri(API_BASE_URL+ "/name/" + COUNTRY_NAME_FI))
				.thenReturn(requestHeadersMock);
		when(requestHeadersMock.retrieve()).thenReturn(responseMock);
		when(responseMock.bodyToFlux(Country.class)).thenReturn(Flux.just(COUNTRY_FI));

		Flux<Country> countries = countryClientService.getByName(COUNTRY_NAME_FI);
		StepVerifier
				.create(countries)
				.expectNextMatches(country -> country.getAlpha2Code().equals(COUNTRY_CODE_FI)
						&& country.getCapital().equals(COUNTRY_CAPITAL_FI)
						&& country.getFlag().equals(COUNTRY_FLAG_URL_FI)
						&& country.getName().equals(COUNTRY_NAME_FI)
						&& country.getPopulation().equals(COUNTRY_POPULATION_FI))
				.expectComplete()
				.verify();
	}

	@Test
	public void getByName_shouldNotReturnCountry() {
		when(webClientMock.get()).thenReturn(requestHeadersUriMock);
		when(requestHeadersUriMock.uri(API_BASE_URL+ "/name/" + COUNTRY_NAME_NOT_FOUND))
				.thenReturn(requestHeadersMock);
		when(requestHeadersMock.retrieve()).thenReturn(responseMock);
		when(responseMock.bodyToFlux(Country.class)).thenReturn(Flux.empty());

		Flux<Country> countries = countryClientService.getByName(COUNTRY_NAME_NOT_FOUND);
		StepVerifier
				.create(countries)
				.expectNextCount(0)
				.expectComplete()
				.verify();

	}
}