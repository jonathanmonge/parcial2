package comEntidadesDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.modelo.Consulta;


public class ConsultaDao {

	public List<Consulta> Consultalista(){
		
		List<Consulta> listaCl = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		
		emf= Persistence.createEntityManagerFactory("UltimoEsfuerzo");
	     em=emf.createEntityManager();
		try {
			
	 em.getTransaction().begin();
	 listaCl=em.createQuery("FROM Consulta").getResultList();
	 
	 em.getTransaction().commit();
	 
	} catch (Exception e) {
		// TODO: handle exception
	System.out.println("saludos"+e);
	}
	return listaCl;
	}
	public void agregarC(Consulta c) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("UltimoEsfuerzo");
	     em=emf.createEntityManager();
		
	     em.getTransaction().begin();
			em.persist(c);
			em.flush();
			em.getTransaction().commit();
		

		
		
	}
	public void Actualizar(Consulta c) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("UltimoEsfuerzo");
		   em=emf.createEntityManager();
		c.getId();
		c.getNombre();
		c.getApellido();
		
		em.getTransaction().begin();
			em.merge(c);
			
			em.flush();
		
			em.getTransaction().commit();
		
	}

	public void EliminarC(Consulta c) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("UltimoEsfuerzo");
		   em=emf.createEntityManager();
		   c= em.getReference(Consulta.class,c.getId());
		   em.getTransaction().begin();
		em.remove(c);
		
		em.flush();

		em.getTransaction().commit();
	}
	
	
}
