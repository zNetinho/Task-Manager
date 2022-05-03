package com.gerenciadortarefas.domain.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciadortarefas.domain.OrdemServico;
import com.gerenciadortarefas.domain.Tarefas;
import com.gerenciadortarefas.domain.DTO.OrdemServicoDTO;
import com.gerenciadortarefas.domain.DTO.TarefaDTO;
import com.gerenciadortarefas.domain.services.TarefasService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tarefas")
public class TarefasResources {
	
	@Autowired
	private TarefasService service;
	
	@GetMapping(value = "/{os}")
	public ResponseEntity<Tarefas> findById(@PathVariable Integer os) {
		Tarefas obj = service.findById(os);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Tarefas>> findAll() {
		List<Tarefas> list = service.findAll();
//		List<TarefaDTO> list2 = list.stream().map(obj -> new TarefaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{os}")
	public ResponseEntity<TarefaDTO> update(@PathVariable Integer os, @RequestBody TarefaDTO objDTO) {
		Tarefas newTarefa = service.update(os, objDTO);
		return ResponseEntity.ok().body(new TarefaDTO(newTarefa));
	}
	
		
	@PostMapping
	public ResponseEntity<Tarefas> create(@Validated @RequestBody Tarefas obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getOs()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{os}")
	public ResponseEntity<Void> delete(@PathVariable Integer os)  {
		service.delete(os);
		return ResponseEntity.noContent().build();
	}
}
