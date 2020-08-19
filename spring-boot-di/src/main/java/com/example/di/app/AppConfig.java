package com.example.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.di.app.models.domain.ItemFactura;
import com.example.di.app.models.domain.Producto;

@Configuration
public class AppConfig {
	
	@Bean//se le podria asignar un nombre al bean @Bean("nombre")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("pelota",2000);
		Producto producto2 = new Producto("huevos",36);
		
		ItemFactura linea1 = new ItemFactura(producto1,1);
		ItemFactura linea2 = new ItemFactura(producto2,2);
		
		return Arrays.asList(linea1, linea2);
	}

}
