package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;

public interface FormacionService {
	void altaFormacion(Formacion formacion);
	List<Formacion> listaFormacion();
}
