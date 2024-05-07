package br.com.sanara.forum.repository;

import java.util.List;

import br.com.sanara.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);

}
