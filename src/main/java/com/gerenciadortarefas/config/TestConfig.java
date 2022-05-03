package com.gerenciadortarefas.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gerenciadortarefas.domain.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	public void instanciaTarefa() {
		this.dbService.iniciaTarefas();
	}
}

