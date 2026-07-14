package com.uisrael.consumofarmacia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductosController {
			
	@GetMapping
	public String leerPagina() {
		return "productos/listar";
	}
	
	@GetMapping("/listar")
	public String listarPagina() {
		return "productos/listar";
	}

}
