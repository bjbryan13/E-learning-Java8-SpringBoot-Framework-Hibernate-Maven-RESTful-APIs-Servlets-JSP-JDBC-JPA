package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.Profesor;

public interface ProfesorRepository  extends JpaRepository<Profesor, Long> {

}
