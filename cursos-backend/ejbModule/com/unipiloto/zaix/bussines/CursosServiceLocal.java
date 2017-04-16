package com.unipiloto.zaix.bussines;

import java.util.List;

import javax.ejb.Local;

import com.unipiloto.zaix.model.Curso;
import com.unipiloto.zaix.model.Estudiante;

@Local
public interface CursosServiceLocal {
	List<Curso> allCursos();
	
	List<Estudiante> allEstudiantes();
}