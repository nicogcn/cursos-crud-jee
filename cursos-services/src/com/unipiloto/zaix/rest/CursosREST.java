package com.unipiloto.zaix.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.unipiloto.zaix.bussines.CursosServiceLocal;
import com.unipiloto.zaix.model.Curso;
import com.unipiloto.zaix.model.Estudiante;

@RequestScoped
@Path("/cursos")
public class CursosREST {
	
	@EJB
	CursosServiceLocal cs;
	
	@GET()
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> listaCursosJson(){
		return cs.allCursos();
	}	
	
	@GET()
	@Path("/estudiantes/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> listaEstudiantesJson(){
		return cs.allEstudiantes();
	}
	
	@POST
	@Path("/registro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Estudiante registroEstudiante(Estudiante estudiante){
		return cs.nuevoEstudiante(estudiante);
	}
	
	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante estudiantePorId(@PathParam(value="id") int id){
		return cs.estudianteById(id);
	}
	
	@PUT
	@Path("/modify/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Estudiante modifyEstudiante(@PathParam(value="id") int id, Estudiante est){
		est.setIdEstudiante(id);
		return cs.modificarEstudiante(est);
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante removeEstudiante(@PathParam(value="id") int id){
		return cs.eliminarEstudiante(id);
	}

}
