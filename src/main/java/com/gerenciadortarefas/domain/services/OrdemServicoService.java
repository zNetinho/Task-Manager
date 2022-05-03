package com.gerenciadortarefas.domain.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadortarefas.domain.OrdemServico;
import com.gerenciadortarefas.domain.Tarefas;
import com.gerenciadortarefas.domain.DTO.OrdemServicoDTO;
import com.gerenciadortarefas.domain.repositories.OrdemServicoRepositories;
import com.gerenciadortarefas.domain.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepositories repository;
	
	@Autowired
	private TarefasService tarefaService;
	
	public OrdemServico findById(Integer os) {
		Optional<OrdemServico> obj = repository.findById(os);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Ordem de serviço não encontrada!"));
	}
	
	public List<OrdemServico> findAll(Integer os_tarefas) {
		tarefaService.findById(os_tarefas);
		return repository.findAllByCategory(os_tarefas);
	}
	
	public OrdemServico update(Integer os, OrdemServicoDTO obj) {
		OrdemServico newObj = findById(os);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(OrdemServico newObj, OrdemServicoDTO obj) {
		newObj.setNomeTarefa(obj.getNomeTarefa());
		newObj.setCusto(obj.getCusto());
		newObj.setDataLimite(obj.getDataLimite());
		
	}
	
	public OrdemServico create(Integer os, OrdemServico obj) {
		obj.setOs(null);
		Tarefas task = tarefaService.findById(os);
		obj.setTarefas(task);
		return repository.save(obj);
	}
	
	public void delete(Integer os) {
		OrdemServico obj = findById(os);
		repository.delete(obj);
	}

	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	public OrdemServico create(OrdemServico obj) {
		obj.setOs(null);
		return repository.save(obj);
	}


}
