package com.caixa.supermercado.caixasupermercadospring.form;

import com.caixa.supermercado.caixasupermercadospring.model.Produto;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AtualizaProdutoForm {

    @NotNull @NotEmpty @Length(min = 1)
    private String nome;
    @NotNull
    private double preco;
    @NotNull
    private int quantidadeEmEstoque;
    @NotNull @NotEmpty
    private String codigoDeBarras;
    @NotNull @NotEmpty
    private LocalDate dataDeValidade;

    public Produto converter(){
        return Produto.builder().nome(nome).preco(preco).quantidadeEmEstoque(quantidadeEmEstoque)
                .codigoDeBarras(codigoDeBarras).dataDeValidade(dataDeValidade).build();
    }

}
