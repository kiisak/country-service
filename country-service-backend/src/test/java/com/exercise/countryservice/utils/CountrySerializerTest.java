package com.exercise.countryservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.exercise.countryservice.helpers.testdata.COUNTRY_FI;
import static org.junit.Assert.*;

@JsonTest
@RunWith(SpringRunner.class)
public class CountrySerializerTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void countrySerialize_shouldSucess() throws Exception {
		String json = objectMapper.writeValueAsString(COUNTRY_FI);

		assertEquals("{\"name\":\"Finland\",\"country_code\":\"FI\",\"capital\":\"Helsinki\",\"population\":5000000,\"flag_file_url\":\"www.maps.com/map_fi.png\"}", json);
	}


}