package com.unipiloto.zaix.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the estudiantes database table.
 * 
 */
@XmlRootElement(name="Estudiante")
@Entity
@Table(name="estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstudiante;

	private int edad;

	private String nombre;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="Curso")
	private Curso cursoBean;

	public Estudiante() {
	}
	
	@XmlElement
	public int getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	@XmlElement
	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@XmlElement
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public Curso getCursoBean() {
		return this.cursoBean;
	}

	public void setCursoBean(Curso cursoBean) {
		this.cursoBean = cursoBean;
	}

}