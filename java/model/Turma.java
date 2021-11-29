package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma implements Serializable {
	private static final long serialversionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer codTurma;
	private String siglaTurma, ano;

	public Turma(Integer codTurma, String siglaTurma, String ano) {
		this.codTurma = codTurma;
		this.siglaTurma = siglaTurma;
		this.ano = ano;
	}

	public Turma() {
	}

	public Integer getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(Integer codTurma) {
		this.codTurma = codTurma;
	}

	public String getSiglaTurma() {
		return siglaTurma;
	}

	public void setSiglaTurma(String siglaTurma) {
		this.siglaTurma = siglaTurma;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
