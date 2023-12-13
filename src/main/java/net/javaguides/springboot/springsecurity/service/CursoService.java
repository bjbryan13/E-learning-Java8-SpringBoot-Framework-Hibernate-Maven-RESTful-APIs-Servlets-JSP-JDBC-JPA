package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.springsecurity.model.Curso;


public interface CursoService {
	List<Curso> getAllCurso();
	void saveCurso(Curso personaa);
	Curso getCursoyId(long id);
	void deleteCursoyId(long id);
	Page<Curso> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
