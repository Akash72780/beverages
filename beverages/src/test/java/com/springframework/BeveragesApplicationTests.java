package com.springframework;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.controller.BeerController;
import com.springframework.entity.BeerDto;

@WebMvcTest(controllers = BeerController.class)
class BeveragesApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getbyBeerId() throws Exception {
		
		mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	void saveNewBeer() throws Exception {
		
		BeerDto beerDto=BeerDto.builder().build();
		String beerDtoToJson=objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoToJson)).andExpect(status().isCreated());
	}
	
	@Test
	void updateBeerId() throws Exception {
		BeerDto beerDto=BeerDto.builder().build();
		String beerDtoToJson=objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(put("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoToJson)).andExpect(status().isNoContent());
	}
	
	

}
