package com.gerenciadortarefas.domain.DTO;

import com.gerenciadortarefas.domain.OrdemServico;

public class OrdemServicoDTO {

	private Integer os;
	private String nomeTarefa;
	private String dataLimite;
	private String custo;
	private Integer ordemApresentacao;
	
	public OrdemServicoDTO(Integer os, String nomeTarefa, String dataLimite, String custo, Integer ordemApresentacao) {
		super();
		this.os = os;
		this.nomeTarefa = nomeTarefa;
		this.dataLimite = dataLimite;
		this.custo = custo;
		this.ordemApresentacao = ordemApresentacao;
	}

	public OrdemServicoDTO(OrdemServico newTarefa) {
		// TODO Auto-generated constructor stub
	}

	public Integer getOs() {
		return os;
	}

	public void setOs(Integer os) {
		this.os = os;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	

	public String getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	public String getCusto() {
		return custo;
	}

	public void setCusto(String custo) {
		this.custo = custo;
	}

	public Integer getOrdemApresentacao() {
		return ordemApresentacao;
	}

	public void setOrdemApresentacao(Integer ordemApresentacao) {
		this.ordemApresentacao = ordemApresentacao;
	}
	
	
}
