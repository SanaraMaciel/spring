package br.com.sanara.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sanara.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
