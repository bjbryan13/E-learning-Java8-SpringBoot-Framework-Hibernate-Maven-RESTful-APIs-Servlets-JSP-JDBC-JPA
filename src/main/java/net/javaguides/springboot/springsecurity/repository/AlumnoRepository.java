package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
