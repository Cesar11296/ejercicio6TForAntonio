package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursoDao;
import com.curso.model.Curso;
@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoDao dao;
	
	@Override
	public void altaCurso(Curso curso) {
		dao.save(curso);
	}
	
	@Override
	public List<Curso> eliminarCurso(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}
	
	@Override
	public void actualizarDuracion(int codCurso, int duracion) {
		Curso c = dao.findById(codCurso).get();
		c.setDuracion(duracion);
		dao.save(c);
	}
	
	@Override
	public Curso buscarCurso(int codCurso) {
		return dao.findById(codCurso).orElse(null);
	}
	
	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

	@Override
	public List<Curso> precioPorCurso(double precioMin, double precioMax) {
		ListIterator it = dao.findAll().listIterator();
		List<Curso> listCurso = new ArrayList<>();
		while(it.hasNext()) {
			Curso c = (Curso) it.next();
			if(c.getPrecio()>= precioMin && c.getPrecio()<=precioMax) {
				listCurso.add(c);
			}
		}
		
		return listCurso;
	}
	

}
