package br.com.sanara.forum.repository;

import br.com.sanara.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByTitulo(String titulo);


    List<Topico> findByCursoNome(String nomeCurso);

    /**outra forma de fazer um mapeamento é utilizar o caracter _ para informar ao spring que
     * vc está querendo pesquisar pelo relaciob=namento Entidade no caso Curso pelo atributo nome dentro0 da
     * classe curso, em caso de houver tbm no topico um atributo chamado cursoNome
     * @param nomeCurso
     * @return
     */
    //List<Topico> findByCurso_Nome(String nomeCurso);

    /**
     * query usando JPQL
     */
    @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(String nomeCurso);

}
