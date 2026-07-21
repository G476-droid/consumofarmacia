package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.ProductosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.ProductosResponseDto;
import com.uisrael.consumofarmacia.services.IProductosServices;

@Controller
@RequestMapping("/producto")
public class ProductosController {

	@Autowired
	private IProductosServices servicioProducto;

	@GetMapping
	public String leerPagina(Model model) {

		List<ProductosResponseDto> resultadoBD = servicioProducto.listarProductos();

		model.addAttribute("listarproductos", resultadoBD);

		return "/productos/listar";
	}

	@GetMapping("/nuevo")
	public String crearProducto(Model model) {

		model.addAttribute("producto", new ProductosRequestDto());

		return "/productos/crear";
	}

	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute ProductosRequestDto producto) {

		servicioProducto.guardarProductos(producto);

		return "redirect:/producto";
	}

}
