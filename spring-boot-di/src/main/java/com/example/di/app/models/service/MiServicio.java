package com.example.di.app.models.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("miServicioSimple")
@Primary
public class MiServicio implements IServicio{
	
	//un @Component debe tener siempre un constructor vacio! siempre
	
	@Override
	public String operacion() {
		
		return "ejecutando algun proceso SIMPLE";
	}
	
	
	
}
