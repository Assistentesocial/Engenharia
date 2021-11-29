package view;

import java.util.Iterator;
import java.util.List;

import control.TurmaControle;
import model.Turma;

public class ProgramaTurma {

	public static void main(String[] args) {
		//inserindo
		Turma novo = new Turma(null, "ENG", "20-11-2021");		
		TurmaControle controle = new TurmaControle();	
		controle.inserirTurma(novo);
		
		//buscando
		novo = controle.buscarPorIdTurma(3); //o id 3 precisa existir no banco, modifique o valor
		System.out.println(novo.getAno()); // substitua por um método get do seu projeto
		
		//modificando
		novo.setAno("12-06-2021"); // no seu caso utilize um método set do seu projeto
		controle.alterar(novo);
		
		//buscar todos
		List<Turma> objetos = controle.buscarTodosTurma();
		for (Iterator iterator = objetos.iterator(); iterator.hasNext();) {
			Turma obj = (Turma) iterator.next();
			System.out.println(obj.getSiglaTurma());
		}
		
		//excluir
		controle.excluirTurma(objetos.get(0));
		
		//excluir por id
		controle.excluirPorIdTurma(3); //o id 3 precisa existir no banco, modifique o valor	
	}
}


