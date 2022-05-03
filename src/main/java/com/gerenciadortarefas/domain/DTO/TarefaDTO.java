package com.gerenciadortarefas.domain.DTO;

import java.io.Serializable;

import com.gerenciadortarefas.domain.Tarefas;

public class TarefaDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String nomeTarefa;
	private String custo;
	private String dataLimite;
	
	public TarefaDTO(Tarefas obj) {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarefaDTO(String nomeTarefa, String custo, String dataLimite) {
		super();
		this.nomeTarefa = nomeTarefa;
		this.custo = custo;
		this.dataLimite = dataLimite;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getCusto() {
		return custo;
	}

	public void setCusto(String custo) {
		this.custo = custo;
	}

	public String getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	
}
