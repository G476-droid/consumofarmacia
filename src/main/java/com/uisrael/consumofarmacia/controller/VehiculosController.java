package com.uisrael.consumofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumofarmacia.model.dto.request.VehiculosRequestDto;
import com.uisrael.consumofarmacia.model.dto.response.VehiculosResponseDto;
import com.uisrael.consumofarmacia.services.IVehiculosServices;


@Controller
@RequestMapping("/vehiculo")
public class VehiculosController {

	@Autowired
	private IVehiculosServices servicioVehiculo;

	@GetMapping
	public String leerPagina(Model model) {

		List<VehiculosResponseDto> resultadoBD = servicioVehiculo.listarVehiculos();

		model.addAttribute("listarvehiculos", resultadoBD);

		return "/vehiculos/listar";
	}

	@GetMapping("/nuevo")
	public String crearVehiculo(Model model) {

		model.addAttribute("vehiculo", new VehiculosRequestDto());

		return "/vehiculos/crear";
	}

	@PostMapping("/guardar")
	public String guardarVehiculo(@ModelAttribute VehiculosRequestDto vehiculo) {

		servicioVehiculo.guardarVehiculos(vehiculo);

		return "redirect:/vehiculo";
	}
}
