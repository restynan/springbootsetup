package com.example.springbootsetup;

import com.example.springbootsetup.card.Card;

import com.example.springbootsetup.card.chainofresponsibitydemo.Chain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSetupApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSetupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Card card = Card.builder()
						.number("677899865")
						.type("AMEX")
						.expiryMonth(12)
						.expiryYear(2023)
						.build();

		Chain chain = new Chain();
		chain.validate(card);


	}
}
