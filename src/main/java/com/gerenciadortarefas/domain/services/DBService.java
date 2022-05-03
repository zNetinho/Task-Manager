package com.gerenciadortarefas.domain.services;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.gerenciadortarefas.domain.OrdemServico;
import com.gerenciadortarefas.domain.Tarefas;
import com.gerenciadortarefas.domain.repositories.OrdemServicoRepositories;
import com.gerenciadortarefas.domain.repositories.TarefasRepositories;


@Service
public class DBService {

	@Autowired
	private OrdemServicoRepositories ordemServicoRepository;
	
	@Autowired
	private TarefasRepositories tarefasRepository;
	

	
	@Bean
	public void iniciaTarefas() {
		
		Tarefas listaTarefas = new Tarefas(null, "Teste", "Teste", "Teste", 1);
		
		Tarefas tarefa4 = new Tarefas(null, "Teste2", "Teste3", "Teste4", 5);
		
		
		OrdemServico tarefa1 = new OrdemServico(null, "Teste", "Teste", "Teste", 1);
		OrdemServico tarefa2 = new OrdemServico(null, "Teste2", "Teste2", "Teste2", 2);
		OrdemServico tarefa3 = new OrdemServico(null, "Teste3", "Teste3", "Teste3", 3);
		
		listaTarefas.getTarefas().addAll(Arrays.asList(tarefa1, tarefa2, tarefa3));

		tarefasRepository.saveAll(Arrays.asList(listaTarefas, tarefa4));
		ordemServicoRepository.saveAll(Arrays.asList(tarefa1, tarefa2, tarefa3));
		
		
	}
}
