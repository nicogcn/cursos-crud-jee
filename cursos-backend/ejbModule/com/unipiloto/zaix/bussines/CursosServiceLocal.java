package com.unipiloto.zaix.bussines;

import java.util.List;

import javax.ejb.Local;

import com.unipiloto.zaix.model.Curso;

@Local
public interface CursosServiceLocal {
	List<Curso> allCursos();
}