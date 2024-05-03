package br.com.sanara;


import br.com.sanara.model.Anuncio;
import br.com.sanara.model.Produto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        var produto = new Produto(1, "TV", "4K", new BigDecimal(2000),"Eletrodoméstico");
        var anuncio = new Anuncio(produto, new BigDecimal(100),20);

        System.out.println(anuncio.toString());
    }
}
