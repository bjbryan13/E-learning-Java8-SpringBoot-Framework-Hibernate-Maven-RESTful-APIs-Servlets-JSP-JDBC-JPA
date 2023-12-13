package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.springsecurity.model.Alumno;

public interface  AlumnoService {
	List<Alumno> getAllAlumno();
	void saveAlumno(Alumno personaa);
	Alumno getAlumnoyId(long id);
	void deleteAlumnoById(long id);
	Page<Alumno> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
