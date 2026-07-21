package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.CategoriasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.CategoriasResponseDto;
import com.uisrael.consumofarmacia.services.ICategoriasServices;

@Controller
@RequestMapping("/categoria")
public class CategoriasController {

	@Autowired
	private ICategoriasServices servicioCategoria;

	@GetMapping
	public String leerPagina(Model model) {

		List<CategoriasResponseDto> resultadoBD = servicioCategoria.listarCategorias();

		model.addAttribute("listarcategorias", resultadoBD);

		return "categorias/listarcategoria";
	}

	@GetMapping("/nuevacategoria")
	public String nuevaCategoria(Model model) {

		model.addAttribute("categoria", new CategoriasRequestDto());

		return "categorias/nuevacategoria";
	}

	@PostMapping("/guardar")
	public String guardarCategorias(@ModelAttribute CategoriasRequestDto categoria) {

		servicioCategoria.guardarCategorias(categoria);

		return "redirect:/categoria";
	}

}
