package com.unipiloto.zaix.bussines;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipiloto.zaix.model.Curso;
import com.unipiloto.zaix.model.Estudiante;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> allEstudiantes() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Estudiante.findAll").getResultList();
	}

	@Override
	public Estudiante nuevoEstudiante(Estudiante EstInstance) {
		// TODO Auto-generated method stub
		em.persist(EstInstance);
		return EstInstance;
	}

	@Override
	public Estudiante estudianteById(int id) {
		// TODO Auto-generated method stub
		return em.find(Estudiante.class, id);
	}

	@Override
	public Estudiante modificarEstudiante(Estudiante EstInstance) {
		em.merge(EstInstance);
		return EstInstance;
	}

	@Override
	public Estudiante eliminarEstudiante(int id) {
		Estudiante e = em.find(Estudiante.class, id);
		em.remove(e);
		return e;
	}

	@Override
	public List<Estudiante> estudiantesDelCurso(int idCurso) {
		Curso c = em.find(Curso.class, idCurso);
		return c.getEstudiantes();
	}

}
