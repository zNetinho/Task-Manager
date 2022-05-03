package com.gerenciadortarefas.domain.resource;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciadortarefas.domain.OrdemServico;
import com.gerenciadortarefas.domain.DTO.OrdemServicoDTO;
import com.gerenciadortarefas.domain.services.OrdemServicoService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/ordem")
public class OrdemServicoResources {

	@Autowired
	private OrdemServicoService service;
	
	@GetMapping(value = "/{os}")
	public ResponseEntity<OrdemServico> findById(@PathVariable Integer os) {
		OrdemServico obj = service.findById(os);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoDTO>> findAll(Integer os_tarefas) {
		List<OrdemServico> list = service.findAll(os_tarefas);
		List<OrdemServicoDTO> list2 = list.stream().map(obj -> new OrdemServicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list2);
		
	}
	
	@PutMapping(value = "/{os}")
	public ResponseEntity<OrdemServicoDTO> update(@PathVariable Integer os, @RequestBody OrdemServicoDTO obj) {
		OrdemServico newObj = service.update(os, obj);
		return ResponseEntity.ok().body(new OrdemServicoDTO(newObj));
	}
	
	@PostMapping
	public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getOs()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{os}")
	public ResponseEntity<Void>delete(@PathVariable Integer os)  {
		service.delete(os);
		return ResponseEntity.noContent().build();
	}

}
