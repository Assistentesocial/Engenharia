package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import model.Turma;

public class TurmaControle {

	private EntityManager em;
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
		em = emf.createEntityManager();

	}

	public void inserirTurma(Turma objeto) {
		   try {
	            em.getTransaction().begin();
	            em.persist(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}

	public void alterar(Turma objeto) {
		 try {
	            em.getTransaction().begin();
	            em.merge(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}

	public void excluirTurma(Turma objeto) {
		 try {
	            em.getTransaction().begin();
	            em.remove(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}

	public void excluirPorIdTurma(Integer id) {
		  try {
	            Turma objeto = buscarPorIdTurma(id);
	            excluirTurma(objeto);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }

	}

	public Turma buscarPorIdTurma(Integer id) {

		return em.find(Turma.class, id);
	}

	public List<Turma> buscarTodosTurma() {
		

		String nomeClasse = Turma.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();

	}

	public Turma buscarPorId() {
		// TODO Auto-generated method stub
		return null;
	}
}
