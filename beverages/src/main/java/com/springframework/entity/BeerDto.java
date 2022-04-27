package com.springframework.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {
	
	private UUID id;
	private Integer version;
	
	private OffsetDateTime creationDate;
	private OffsetDateTime lastModifiedDate;
	
	private String beerName;
	private BeerStyle beerStyle;
	
	private Long utc;
	private BigDecimal price;
	
	private Integer quanityOnHand;

}
