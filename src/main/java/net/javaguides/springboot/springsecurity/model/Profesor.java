package net.javaguides.springboot.springsecurity.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profesor {
	 @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private double edad;
    private String correo;
    private String direccion;
    private double dni;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private Set<Matricula> matricula;
    
	public Profesor() {
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
	public double getEdad() {
		return edad;
	}
	public void setEdad(double edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getDni() {
		return dni;
	}
	public void setDni(double dni) {
		this.dni = dni;
	}
    
    
}
