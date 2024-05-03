package br.com.sanara.loja.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded //indica que a classe � embut�vel dentro de uma entidade
    //� bom para "quebrar" os atributos de forma que diminua os atributos da classe
    private DadosPessoais dadosPessoais;

    public Cliente(String nome, String cpf) {
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    //m�todo delegate utilizado para evitar erros ao criar classes embedded
    //assim n�o � necess�rio mudar em muitas partes do c�digo
    public String getNome() {
        return this.dadosPessoais.getNome();
    }


}
