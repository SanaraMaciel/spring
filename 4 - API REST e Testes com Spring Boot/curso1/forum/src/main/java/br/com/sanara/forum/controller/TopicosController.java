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
    cria uma lista de topicos e retorna
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
    @RequestMapping("/topicosAll")
    public List<TopicoDto> lista() {
        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converter(topicos);
    }


    /** consulta com filtros
     * @param  /nome do curso
     * @return lista de topicos conforme filtro
     */
    @RequestMapping("/topicos")
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }


}
