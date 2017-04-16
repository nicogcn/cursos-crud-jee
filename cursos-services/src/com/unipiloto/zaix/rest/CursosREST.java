package com.unipiloto.zaix.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.unipiloto.zaix.bussines.CursosServiceLocal;
import com.unipiloto.zaix.model.Curso;
import com.unipiloto.zaix.model.Estudiante;

@RequestScoped
@Path("/rest")
public class CursosREST {
	
	@EJB
	CursosServiceLocal cs;
	
	@GET()
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Curso> listaCursos(){
		return cs.allCursos();
	}
	
	@GET()
	@Path("/jsonall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> listaCursosJson(){
		return cs.allCursos();
	}
	
	@GET()
	@Path("/all-estudiantes")
	@Produces(MediaType.APPLICATION_XML)
	public List<Estudiante> listaEstudiantes(){
		return cs.allEstudiantes();
	}
	
	@GET()
	@Path("/json-estudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> listaEstudiantesJson(){
		return cs.allEstudiantes();
	}

}
