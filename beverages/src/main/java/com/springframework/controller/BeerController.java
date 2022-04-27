package com.springframework.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.entity.BeerDto;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {
	
	@GetMapping("/{id}")
	public ResponseEntity<BeerDto> getbyBeerId(@PathVariable("id") UUID id){
		
		return new ResponseEntity<>(BeerDto.builder().build(),HttpStatus.OK);
	}

	public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity updateBeerId(@PathVariable("id") UUID id,@RequestBody BeerDto beerDto) {
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
