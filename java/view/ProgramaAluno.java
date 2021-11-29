package view;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import control.AlunoControle;
import control.TurmaControle;
import model.Aluno;
import model.Turma;

public class ProgramaAluno {
	public static void main(String[] args) {
		//inserindo
		Aluno novo = new Aluno(null, "bruno", "masculino", "10-031989");		
		AlunoControle controle = new AlunoControle();	
		controle.inserir(novo);
		
		//buscando
		novo = controle.buscarPorId(3); //o id 3 precisa existir no banco, modifique o valor
		System.out.println(novo. getNomeAluno()); // substitua por um método get do seu projeto
		
		//modificando
		novo. setNomeAluno("bruno queiroz"); // no seu caso utilize um método set do seu projeto
		controle.alterar(novo);
		
		//buscar todos
		List<Aluno> objetos = controle.buscarTodos();
		for (Iterator iterator = objetos.iterator(); iterator.hasNext();) {
			Aluno obj = (Aluno) iterator.next();
			System.out.println(obj. getNomeAluno());
		}
		
		//excluir
		controle.excluir(objetos.get(0));
		
		
		
		//excluir por id
		controle.excluirPorId(3); //o id 3 precisa existir no banco, modifique o valor	
		
		
		
	}
}
