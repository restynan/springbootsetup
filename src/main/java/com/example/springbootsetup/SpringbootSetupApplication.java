package com.example.springbootsetup;

import com.example.springbootsetup.chainofresponsibitydemo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSetupApplication implements CommandLineRunner {
	@Autowired
	OrderReceiver orderReceiver;

	@Autowired
	@Qualifier("MichiganOrderHandler")
	OrderHandler michiganOrderHandler;

	@Autowired
	@Qualifier("CaliforniaOrderHandler")
	OrderHandler californiaOrderHandler;

	@Autowired
	@Qualifier("TexasOrderHandler")
	OrderHandler texasOrderHandler;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSetupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("teeeeeest");
		// create chain
		texasOrderHandler = TexasOrderHandler.builder().build();
		michiganOrderHandler = MichiganOrderHandler.builder().nextHandler(texasOrderHandler).build();
		californiaOrderHandler = CaliforniaOrderHandler.builder().nextHandler(michiganOrderHandler).build();



		orderReceiver = OrderReceiver.builder().orderHandler(michiganOrderHandler).build();
		orderReceiver.handleOrder("Texas Order to be processed");
		orderReceiver.handleOrder("California Order to be processed");


	}
}
