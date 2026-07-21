package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.RutasRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.RutasResponseDto;
import com.uisrael.consumofarmacia.services.IRutasServices;


@Controller
@RequestMapping("/ruta")
public class RutasController {

	@Autowired
	private IRutasServices servicioRuta;

	@GetMapping
	public String leerPagina(Model model) {

		List<RutasResponseDto> resultadoBD = servicioRuta.listarRutas();

		model.addAttribute("listarrutas", resultadoBD);

		return "/rutas/listar";
	}

	@GetMapping("/nuevo")
	public String crearRuta(Model model) {

		model.addAttribute("ruta", new RutasRequestDto());

		return "/rutas/crear";
	}

	@PostMapping("/guardar")
	public String guardarRuta(@ModelAttribute RutasRequestDto ruta) {

		servicioRuta.guardarRutas(ruta);

		return "redirect:/ruta";
	}

}
