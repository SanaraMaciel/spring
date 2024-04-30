package br.com.sanara;

import br.com.sanara.model.Produto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //importa uma lista de produtos em formato csv e faz o parse p/ um obj java produto
        List<Produto> produtos = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv")).withType(Produto.class).build().parse();


        for (Produto produto : produtos) {
            System.out.println(produto);
        }


    }
}