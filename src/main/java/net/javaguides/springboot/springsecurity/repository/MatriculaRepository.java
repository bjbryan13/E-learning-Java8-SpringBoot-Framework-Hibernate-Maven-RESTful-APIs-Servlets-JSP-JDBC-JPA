package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.Matricula;

public interface MatriculaRepository  extends JpaRepository<Matricula, Long> {

}
