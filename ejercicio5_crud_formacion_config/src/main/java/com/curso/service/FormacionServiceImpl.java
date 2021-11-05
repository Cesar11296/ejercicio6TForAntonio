package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService{

	@Autowired
	RestTemplate template;
	String url="http://servicio-cursos/";
	@Override
	public void altaFormacion(Formacion formacion) {
		formacion.setDuracion(formacion.getAsignaturas()*10);
		template.postForLocation(url+"curso", formacion);
	}

	@Override
	public List<Formacion> listaFormacion() {
		List<Formacion> listFormacion = Arrays.asList(template.getForObject(url+"cursos", Formacion[].class));
		for(Formacion f : listFormacion)
		{
		    if(f.getDuracion() >= 50) {
		    	f.setAsignaturas(10);
		    }else {
		    	f.setAsignaturas(5);
		    }
		}
		return listFormacion;
	}

}
