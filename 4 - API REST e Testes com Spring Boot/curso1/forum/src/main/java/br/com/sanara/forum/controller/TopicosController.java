package br.com.sanara.forum.controller;

import java.util.Arrays;
import java.util.List;

import br.com.sanara.forum.controller.dto.TopicoDto;
import br.com.sanara.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sanara.forum.modelo.Curso;
import br.com.sanara.forum.modelo.Topico;

@RestController
public class TopicosController {
	/*
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		Topico topico = new Topico("Dúvida", "Dúvida com Spring2", new Curso("Spring", "Programação"));
		
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
	}*/


    @Autowired
    private TopicoRepository topicoRepository;


    /**
     * retorna os dados vindo do banco de dados - topicos
     *
     * @return lista de topicos
     */
    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converter(topicos);
    }


}
