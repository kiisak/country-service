package com.exercise.countryservice.domain;
import com.exercise.countryservice.utils.CountrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CountrySerializer.class)
public class Country {

	private String name;
	private String alpha2Code;
	private String capital;
	private Long population;
	private String flag;

	public Country() {
	}

	public Country(final String name, final String alpha2Code, final String capital, final Long population,
				   final String flag) {
		this.name = name;
		this.alpha2Code = alpha2Code;
		this.capital = capital;
		this.population = population;
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
