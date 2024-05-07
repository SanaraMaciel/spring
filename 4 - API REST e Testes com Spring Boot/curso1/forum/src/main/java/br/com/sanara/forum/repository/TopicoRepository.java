package br.com.sanara.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sanara.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
