package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private static final long serialversionUID = 1L;
	private Integer codAluno;
	private String nomeAluno, sexo, dataDeNascimento;

	public Aluno(Integer codAluno, String nomeAluno, String sexo, String dataDeNascimento) {
		this.codAluno = codAluno;
		this.nomeAluno = nomeAluno;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
	}

	public Aluno() {
	}

	public Integer getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(Integer codAluno) {
		this.codAluno = codAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
}

