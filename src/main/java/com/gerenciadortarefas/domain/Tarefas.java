package com.gerenciadortarefas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tarefas")
public class Tarefas implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer os;
		private String nomeTarefa;
		private String custo;
		private String dataLimite;
		private Integer ordemApresentacao;
		
		@JsonIgnore
		@OneToMany(mappedBy = "tarefas")
		private List<OrdemServico> tarefas = new ArrayList<>();
		
		public Tarefas(Integer os, String nomeTarefa, String custo, String dataLimite, Integer ordemApresentacao) {
			super();
			this.os = os;
			this.nomeTarefa = nomeTarefa;
			this.custo = custo;
			this.dataLimite = dataLimite;
			this.ordemApresentacao = ordemApresentacao;
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
			Tarefas other = (Tarefas) obj;
			return Objects.equals(os, other.os) && Objects.equals(nomeTarefa, other.nomeTarefa)
					&& Objects.equals(custo, other.custo)
					&& Objects.equals(dataLimite, other.dataLimite) && Objects.equals(ordemApresentacao, other.ordemApresentacao)
					&& Objects.equals(tarefas, other.tarefas);
		}

		public Tarefas() {
			super();
		}

		public Tarefas(Tarefas obj) {
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

		public List<OrdemServico> getTarefas() {
			return tarefas;
		}

		public void setTarefas(List<OrdemServico> tarefas) {
			this.tarefas = tarefas;
		}
		
		
		
	}
