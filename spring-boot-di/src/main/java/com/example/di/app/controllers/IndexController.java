package com.example.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.di.app.models.service.IServicio;

//import com.example.di.app.models.service.MiServicio;

@Controller
public class IndexController {
	
	//asi seria sin inyeccion de dependencia, pero esto genera acoplamiento la idea es no crear la instancia, la idea es que nos llegue
	//la instancia y no tener que instanciarla aca
	//private MiServicio servicio = new MiServicio();
	//@Autowired
	//private MiServicio servicio;//esto sigue acoplado porque es una Clase, si la clase cambia complica, lo mejor es una interface
	
	@Autowired
	private IServicio servicio;//ahora depende de algo generico (interface) no de algo concreto(clase)

	@GetMapping({"/", "/index", ""})
	public String index(Model modelo) {
		
		modelo.addAttribute("objeto", servicio.operacion());
		
		return "index";
	}	
}
