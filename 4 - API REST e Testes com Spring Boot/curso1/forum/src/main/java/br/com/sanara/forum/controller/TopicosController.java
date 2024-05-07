package br.com.sanara.forum.controller;

import br.com.sanara.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.sanara.forum.controller.dto.TopicoDto;
import br.com.sanara.forum.form.AtualizacaoTopicoForm;
import br.com.sanara.forum.form.TopicoForm;
import br.com.sanara.forum.modelo.Topico;
import br.com.sanara.forum.repository.CursoRepository;
import br.com.sanara.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
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

    @Autowired
    private CursoRepository cursoRepository;


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


    /**
     * consulta com filtros
     *
     * @param /nome do curso
     * @return lista de topicos conforme filtro
     */
    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    /**
     * cadastrando um tópico
     *
     * @param /nome do curso
     * @return topico criado
     */
    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository, form);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }


    /**
     * detalhando um tópico
     *
     * @param /nome do topico
     * @return topico
     */
    @GetMapping("/{id}")
    public DetalhesDoTopicoDto detalhar(@PathVariable("id") Long id) {
        //metodo getOne antigo:
        //Topico topico = topicoRepository.getOne(id);

        //Utilizar agora o metodo getReferenceById:
        Topico topico = topicoRepository.getReferenceById(id);
        return new DetalhesDoTopicoDto(topico);
    }


    /**
     * altera um tópico
     *
     * @param /formulário
     * @return topico alterado
     */
    @PutMapping("/{id}")
    // anotação TRansactional : efetua o commit automático da transação, caso não ocorra uma exception
    //Executa o método dentro de um contexto transacional
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Topico topico = form.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

}

