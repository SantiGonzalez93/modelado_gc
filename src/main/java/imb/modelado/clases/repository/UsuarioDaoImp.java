package imb.modelado.clases.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import imb.modelado.clases.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;



@Repository

@Transactional
public class UsuarioDaoImp implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> obtenerUsuario() {
		String query = "from Usuario";
		List <Usuario>  resultado = entityManager.createQuery(query).getResultList();
		
		return resultado;
		
	}

	
}
