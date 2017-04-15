package com.unipiloto.zaix.bussines;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipiloto.zaix.model.Curso;

/**
 * Session Bean implementation class CursosServiceImpl
 */
@Stateless
@LocalBean
public class CursosServiceImpl implements CursosServiceLocal {
	
	@PersistenceContext
	EntityManager em;
    
    public CursosServiceImpl() {}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> allCursos() {		
		return em.createNamedQuery("Curso.findAll").getResultList();
	}

}
