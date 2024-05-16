package imb.modelado.clases.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.modelado.clases.entity.Usuario;
import imb.modelado.clases.repository.UsuarioDao;

@RestController
public class UsuarioController {
	
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "mensaje")
	public String mensaje () {
		return "hola mundo";
	}
	
	@RequestMapping(value = "persona")
	public List<String> listarPersona(){
		
		return  List.of("Diego", "Juan", "Jose");
	}
	
	@RequestMapping(value = "usuario")
	public Usuario listarUsuarios() {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Santi");
		usuario1.setApellido("González");
		usuario1.setEmail("prueba@gmail.com");
		usuario1.setTelefono("2612439807");
		usuario1.setPassword("Santi123");
		return usuario1;
		
	}
	
	@RequestMapping(value = "usuario/{id}")
	public Usuario getUsuario(@PathVariable long id) {
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre("Santi");
		usuario.setApellido("González");
		usuario.setEmail("prueba@gmail.com");
		usuario.setTelefono("2612439807");
		usuario.setPassword("Santi123");
		return usuario;
		
	}
	
	
	@RequestMapping(value = "usuarios")
	public List <Usuario> listarVariosUsuarios() {
		
		List<Usuario> lsUsuario = new ArrayList<>();
		
		Usuario usuario1 = new Usuario();
		usuario1.setId(1L);
		usuario1.setNombre("Santi");
		usuario1.setApellido("González");
		usuario1.setEmail("prueba@gmail.com");
		usuario1.setTelefono("2612439807");
		usuario1.setPassword("Santi123");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);
		usuario2.setNombre("Santi");
		usuario2.setApellido("González");
		usuario2.setEmail("prueba@gmail.com");
		usuario2.setTelefono("2612439807");
		usuario2.setPassword("Santi123");
		
		Usuario usuario3 = new Usuario();
		usuario3.setId(3L);
		usuario3.setNombre("Santi");
		usuario3.setApellido("González");
		usuario3.setEmail("prueba@gmail.com");
		usuario3.setTelefono("2612439807");
		usuario3.setPassword("Santi123");
		
		//agregamos los objetos a la coleccion
		lsUsuario.add(usuario1);
		lsUsuario.add(usuario2);
		lsUsuario.add(usuario3);
		
		return lsUsuario;
		
	}
	
	@RequestMapping(value = "api/usuarios")
	public List<Usuario> getUsuario(){
		List<Usuario> user = usuarioDao.obtenerUsuario();
		return user;
	}
}
