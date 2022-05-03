package com.gerenciadortarefas.domain.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadortarefas.domain.OrdemServico;
import com.gerenciadortarefas.domain.Tarefas;
import com.gerenciadortarefas.domain.DTO.TarefaDTO;
import com.gerenciadortarefas.domain.repositories.OrdemServicoRepositories;
import com.gerenciadortarefas.domain.repositories.TarefasRepositories;
import com.gerenciadortarefas.domain.services.exceptions.DataIntegrityViolationException;
import com.gerenciadortarefas.domain.services.exceptions.ObjectNotFoundException;

@Service
public class TarefasService {
	
	@Autowired 
	private TarefasRepositories repository;
	
	
	public Tarefas findById(Integer os) {
		Optional<Tarefas> obj = repository.findById(os);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Tarefas> findAll() {
		return repository.findAll();
	}
	
	public Tarefas create(Tarefas obj) {
		obj.setOs(null);
		return repository.save(obj);
	}

	public Tarefas update(Integer os, TarefaDTO objDTO) {
		Tarefas tarefa = findById(os);
		tarefa.setNomeTarefa(objDTO.getNomeTarefa());
		tarefa.setCusto(objDTO.getCusto());
		tarefa.setDataLimite(objDTO.getDataLimite());
		return repository.save(tarefa);
		
	}
	
	public void delete(Integer os) {
		findById(os);
		try {
			repository.deleteById(os);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("A tarefa ainda não foi concluida");
		}
 	}
	
	

}
