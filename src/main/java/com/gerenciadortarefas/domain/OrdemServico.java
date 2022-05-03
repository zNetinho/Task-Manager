package com.gerenciadortarefas.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrdemServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer os;
	@JoinColumn(name = "nomeTarefa", columnDefinition = "nomeTarefa")
	private String nomeTarefa;
	@JoinColumn(name = "custo", columnDefinition = "custo")
	private String custo;
	@JoinColumn(name = "dataLimite", columnDefinition = "dataLimite")
	private String dataLimite;
	@JoinColumn(name = "ordemApresentacao", columnDefinition = "ordemApresentacao")
	private Integer ordemApresentacao;
	
	@ManyToOne
	private Tarefas tarefas;

	public OrdemServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdemServico(Integer os, String nomeTarefa, String custo, String dataLimite, Integer ordemApresentacao) {
		super();
		this.os = getOs();
		this.nomeTarefa = nomeTarefa;
		this.custo = custo;
		this.dataLimite = dataLimite;
		this.ordemApresentacao = ordemApresentacao;
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

	public Integer getOrdemApresentacao() {
		return ordemApresentacao;
	}

	public void setOrdemApresentacao(Integer ordemApresentacao) {
		this.ordemApresentacao = ordemApresentacao;
	}

	public Tarefas getTarefas() {
		return tarefas;
	}

	public void setTarefas(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(custo, dataLimite, nomeTarefa, ordemApresentacao, os, tarefas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(os, other.os) && Objects.equals(nomeTarefa, other.nomeTarefa)
				&& Objects.equals(custo, other.custo)
				&& Objects.equals(dataLimite, other.dataLimite) && Objects.equals(ordemApresentacao, other.ordemApresentacao)
				&& Objects.equals(tarefas, other.tarefas);
	}
	
	

}
