package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

		@GetMapping("/")
		public String index(Model model) {
			return "variables/index";
		}
	
		@GetMapping("/string/{texto}")
		public String variables(@PathVariable String texto,Model model) {
			//el nombre del parametro tiene que ser igual al {texto} o hay que aclarar en la anotacion con @PathVariable(name="texto")
			
			model.addAttribute("resultado","el parametro pasado en la ruta es: " + texto);
			
			return "variables/ver";
			
		}
		
		@GetMapping("/string/{texto}/{numero}")//como se llaman igual no es necesario aclarar el name
		public String variables(@PathVariable(name="texto") String texto,@PathVariable(name="numero")Integer numero,Model model) {
			//el nombre del parametro tiene que ser igual al {texto} o hay que aclarar en la anotacion con @PathVariable(name="texto")
			
			model.addAttribute("resultado","el parametro pasado en la ruta es: " + texto + " y el numero es: "+ numero);
			
			return "variables/ver";
			
		}
}
