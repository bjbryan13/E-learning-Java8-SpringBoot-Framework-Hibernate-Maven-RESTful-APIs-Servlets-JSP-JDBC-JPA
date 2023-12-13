package net.javaguides.springboot.springsecurity.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	 @Id

	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String nombre;
	    private double grado;
	    
	    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	    private Set<Matricula> matricula;
	    
		public Curso() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getGrado() {
			return grado;
		}

		public void setGrado(double grado) {
			this.grado = grado;
		}
		
		
	 
}
