package com.brenno.simulador_de_bolsa;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SimuladorDeBolsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimuladorDeBolsaApplication.class, args);
	}

}
