package br.com.sanara.forum.form;

import br.com.sanara.forum.modelo.Topico;
import br.com.sanara.forum.repository.TopicoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoTopicoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;

    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String mensagem;

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);

        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }

    public @NotNull @NotEmpty @Length(min = 5) String getTitulo() {
        return titulo;
    }

    public @NotNull @NotEmpty @Length(min = 10) String getMensagem() {
        return mensagem;
    }

    public void setTitulo(@NotNull @NotEmpty @Length(min = 5) String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(@NotNull @NotEmpty @Length(min = 10) String mensagem) {
        this.mensagem = mensagem;
    }
}
