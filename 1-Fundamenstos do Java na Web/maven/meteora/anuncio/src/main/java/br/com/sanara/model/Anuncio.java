package br.com.sanara.model;


import java.math.BigDecimal;

public class Anuncio {

    private Produto produto;
    private BigDecimal preco;
    private Integer quantidade;

    public Anuncio(Produto produto, BigDecimal preco, Integer quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "produto=" + produto +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

