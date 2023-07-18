package com.syst.trades;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mm = new ModelMapper();
		mm.getConfiguration().setAmbiguityIgnored(true);
		return mm;
	}
}
