package com.exercise.countryservice.utils;

import com.exercise.countryservice.domain.Country;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CountrySerializer extends StdSerializer<Country> {

	public CountrySerializer() {
		this(null);
	}

	public CountrySerializer(Class<Country> t) {
		super(t);
	}

	@Override
	public void serialize(
			Country value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeStringField("name", value.getName());
		jgen.writeStringField("country_code", value.getAlpha2Code());
		jgen.writeStringField("capital", value.getCapital());
		jgen.writeNumberField("population", value.getPopulation());
		jgen.writeStringField("flag_file_url", value.getFlag());
		jgen.writeEndObject();
	}
}
