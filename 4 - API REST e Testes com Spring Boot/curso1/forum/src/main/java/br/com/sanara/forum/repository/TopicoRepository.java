package br.com.sanara.forum.repository;

import br.com.sanara.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByTitulo(String titulo);


    List<Topico> findByCursoNome(String nomeCurso);

    /**
     * query usando JPQL
     */
    @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(String nomeCurso);

}
