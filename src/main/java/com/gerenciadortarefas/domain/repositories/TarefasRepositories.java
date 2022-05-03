package com.gerenciadortarefas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciadortarefas.domain.Tarefas;
import com.gerenciadortarefas.domain.DTO.TarefaDTO;

@Repository
public interface TarefasRepositories extends JpaRepository<Tarefas, Integer> {

	Tarefas save(TarefaDTO objDTO);


}
