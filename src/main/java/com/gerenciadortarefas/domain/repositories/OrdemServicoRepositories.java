package com.gerenciadortarefas.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciadortarefas.domain.OrdemServico;

@Repository
public interface OrdemServicoRepositories extends JpaRepository<OrdemServico, Integer>{

	@Query("SELECT obj FROM OrdemServico obj WHERE obj.tarefas.os= :os_tarefas")
	List<OrdemServico> findAllByCategory(@Param (value = "os_tarefas")Integer os_tarefas);
}
