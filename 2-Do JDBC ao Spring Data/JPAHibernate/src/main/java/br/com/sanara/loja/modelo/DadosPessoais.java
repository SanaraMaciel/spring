package br.com.sanara.loja.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //indica que a classe � embut�vel dentro de uma entidade
public class DadosPessoais {

    private String nome;

    private String cpf;
}
