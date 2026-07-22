package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.InventariosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.InventariosResponseDto;
import com.uisrael.consumofarmacia.services.IInventariosServices;


@Controller
@RequestMapping("/inventario")
public class InventariosController {
	
	 @Autowired
	    private IInventariosServices servicioInventario;
	 
	 @GetMapping
	    public String leerPagina(Model model) {

	        List<InventariosResponseDto> resultadoBD =
	                servicioInventario.listarInventarios();

	        model.addAttribute("listarinventarios", resultadoBD);

	        return "/inventarios/listarinventario";
	    }

	    @GetMapping("/nuevo")
	    public String crearInventario(Model model) {

	        model.addAttribute(
	                "inventario",
	                new InventariosRequestDto()
	        );

	        return "/inventarios/nuevoinventario";
	    }

	    @PostMapping("/guardar")
	    public String guardarInventario(
	            @ModelAttribute InventariosRequestDto inventario) {

	        servicioInventario.guardarInventarios(inventario);

	        return "redirect:/inventario";
	    }

}
