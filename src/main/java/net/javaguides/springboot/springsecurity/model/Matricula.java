package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;   

	 @ManyToOne
	 @JoinColumn
	 private Curso curso;
	 
	 @ManyToOne
	 @JoinColumn
	 private Profesor profesor;
	 
	 @ManyToOne
	 @JoinColumn
	 private Alumno alumno;

	 public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Matricula(Curso curso, Profesor profesor, Alumno alumno) {
		this.curso = curso;
		this.profesor = profesor;
		this.alumno = alumno;
	}

	 
	 public Matricula() {
		super();
		
		// TODO Auto-generated constructor stub
	}



}
    