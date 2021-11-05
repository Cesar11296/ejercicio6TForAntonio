package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
@RestController
public class CursoController {
	
	@Autowired
	CursoService service;
	@ApiOperation(value="Da de alta un curso mediante el envio de JSON")
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@ApiParam(value="Estructura JSON con los datos del nuevo curso") @RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	@ApiOperation(value="Eliminación de un curso mediante el envio del código del curso (codCurso)")
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@ApiParam(value="Código del curso a eliminar") @PathVariable("codCurso") int codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	@ApiOperation(value="Actualización de la duración de un curso mediante el envio del código del curso (codCurso) y su nueva duración")
	@PutMapping(value="curso/{codCurso}/{duracion}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarDuracion(@ApiParam(value="Código del curso a actualizar") @PathVariable("codCurso") int codCurso, @ApiParam(value="Duración del curso a eliminar") @PathVariable("duracion") int duracion ) {
		System.out.println(duracion);
		service.actualizarDuracion(codCurso, duracion);
	}
	
	@ApiOperation(value="Obtención de los cursos mediante el envio de un precio mínimo (precioMin) y un precio máximo (precioMax)")
	@GetMapping(value="curso/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCurso(@ApiParam(value="Precio mínimo del curso a buscar") @PathVariable("precioMin") double precioMin, @ApiParam(value="Precio máximo del curso a buscar") @PathVariable("precioMax") double precioMax) {
		return service.precioPorCurso(precioMin, precioMax);
	}
	
	@ApiOperation(value="Busqueda de un curso mediante el envio del código del curso (codCurso)")
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@ApiParam(value="código del curso a buscar") @PathVariable("codCurso") int codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	@ApiOperation(value="Listado de todos los cursos")
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listarCurso() {
		return service.cursos();
	}
}
