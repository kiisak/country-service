package com.exercise.countryservice.helpers;

import com.exercise.countryservice.domain.Country;

public class testdata {

	public static String COUNTRY_NAME_FI = "Finland";
	public static String COUNTRY_CODE_FI = "FI";
	public static String COUNTRY_CAPITAL_FI = "Helsinki";
	public static Long COUNTRY_POPULATION_FI =	5000000L;
	public static String COUNTRY_FLAG_URL_FI	= "www.maps.com/map_fi.png";

	public static String COUNTRY_NAME_FR = "France";
	public static String COUNTRY_CODE_FR = "FR";
	public static String COUNTRY_CAPITAL_FR = "Paris";
	public static Long COUNTRY_POPULATION_FR =	40000000L;
	public static String COUNTRY_FLAG_URL_FR	= "www.maps.com/fr_flag.png";

	public static String COUNTRY_NAME_NOT_FOUND = "abcd1234";

	public static Country COUNTRY_FI = new Country(COUNTRY_NAME_FI, COUNTRY_CODE_FI, COUNTRY_CAPITAL_FI,
			COUNTRY_POPULATION_FI, COUNTRY_FLAG_URL_FI);

	public static Country COUNTRY_FR = new Country(COUNTRY_NAME_FR, COUNTRY_CODE_FR, COUNTRY_CAPITAL_FR,
			COUNTRY_POPULATION_FR, COUNTRY_FLAG_URL_FR);
}
