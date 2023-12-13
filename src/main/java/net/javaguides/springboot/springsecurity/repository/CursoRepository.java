package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.Alumno;
import net.javaguides.springboot.springsecurity.model.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Long>{

}
