package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//por defecto requestmapping es de tipo get pero se puede especificar otro
	//con el method=RequestMethod.POST
	//otra seria @GetMapping(value="/index")
	//puede estar mapeado a varias url ej: @GetMapping({"/index","/","/home"})
	@RequestMapping(value="/index")
	public String index(Model model) {
		
		model.addAttribute("titulo", this.textoIndex);
		
		//retorna el nombre de la vista a ejecutar
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Pepe");
		usuario.setApellido("Blabla");
		usuario.setEmail("correo@email.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", this.textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model){
		model.addAttribute("titulo", this.textoListar);
		return "listar";
	}
	
	//el metodo asigna al atributo usuarios del modelo la lista de usuarios
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andres", "Guzman","andre@gmail.com"));
		usuarios.add(new Usuario("Pepe", "Lopez","pepito@gmail.com"));
		usuarios.add(new Usuario("Julio", "Prof","juliop@gmail.com"));
		return usuarios;
	}
}
