package br.com.sanara.forum.form;

import br.com.sanara.forum.modelo.Curso;
import br.com.sanara.forum.modelo.Topico;
import br.com.sanara.forum.repository.CursoRepository;

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository, TopicoForm form) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(form.titulo, form.mensagem, curso);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}
