package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Pessoa;

public class PessoaService 
{
	private EntityManagerFactory factory;
	public String main() 
	{
		try 
		{
			factory = Persistence.createEntityManagerFactory("aluga");
			EntityManager em = factory.createEntityManager();

			Pessoa p = new Pessoa();
			p.setId(3);
			p.setNome("fulano");
			p.setIdade(32);

			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();

			em.close();
			factory.close();
			
			return "ok";
		} 
		catch (Exception ex) 
		{
			return ex.getMessage();
		}
	}
}
