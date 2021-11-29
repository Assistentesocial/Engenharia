package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;
import model.Turma;

public class AlunoControle {

	private EntityManager em;
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
		em = emf.createEntityManager();

	}

	public void inserir(Aluno objeto) {
		   try {
	            em.getTransaction().begin();
	            em.persist(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}

	public void alterar(Aluno objeto) {
		 try {
	            em.getTransaction().begin();
	            em.merge(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}

	public void excluir(Aluno objeto) {
		 try {
	            em.getTransaction().begin();
	            em.remove(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}

	public void excluirPorId(Integer id) {
		  try {
	            Aluno objeto = buscarPorId(id);
	            excluir(objeto);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }

	}

	public Aluno buscarPorId(Integer id) {

		return em.find(Aluno.class, id);
	}

	public List<Aluno> buscarTodos() {

		String nomeClasse = Aluno.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();

	}

	public void inserir(Turma nova) {
		// TODO Auto-generated method stub
		
	}
}
