package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
@RestController
public class FormacionController {

	@Autowired
	FormacionService service;
	
	@ApiOperation(value="Da de alta una formación mediante el envio de JSON")
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaFormacion(@ApiParam(value="Estructura JSON con los datos de la nueva formación") @RequestBody Formacion formacion){
		service.altaFormacion(formacion);
	}
	
	@ApiOperation(value="Devuelve un listado con todas las formaciones disponibles")
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listaFormacion() {
		return service.listaFormacion();
	}
}
