package com.caixa.supermercado.caixasupermercadospring.form;

import com.caixa.supermercado.caixasupermercadospring.model.Produto;
import com.caixa.supermercado.caixasupermercadospring.repository.CategoriaRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ProdutoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private double preco;
    @NotNull
    private int quantidadeEmEstoque;
    @NotNull @NotEmpty
    private String codigoDeBarras;
    @NotNull @NotEmpty
    private String nomeCategoria;
    @NotNull @NotEmpty
    private LocalDate dataDeValidade;


    public Produto conversor(CategoriaRepository categoria){
        return new Produto(nome, quantidadeEmEstoque, preco, dataDeValidade, categoria.findByNome(nomeCategoria));
    }
}
