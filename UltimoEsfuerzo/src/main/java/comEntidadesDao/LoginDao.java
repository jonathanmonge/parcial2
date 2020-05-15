package comEntidadesDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.modelo.Usuario;
public class LoginDao {
public List<Usuario> RevisarUsuario(Usuario usu){
	
	
	List<Usuario> listaUsser = new ArrayList<>();
	EntityManager em;
	EntityManagerFactory emf;
	
	emf= Persistence.createEntityManagerFactory("UltimoEsfuerzo");
     em=emf.createEntityManager();
	try {
		
 em.getTransaction().begin();
 listaUsser=em.createQuery("FROM Usuario  AS u where u.nombre='"+usu.getNombre()+"' and u.contrasenia='"+usu.getContrasenia()+"'").getResultList();
 
 
 em.getTransaction().commit();
 // for(RUsuario dato:listaUsser) { 
//usu.setIdUsuarios(dato.getIdUsuarios());}
 
} catch (Exception e) {
	// TODO: handle exception
System.out.println("saludos"+e);
}
return listaUsser;
}
}