package com.caixa.supermercado.caixasupermercadospring.dto;

import com.caixa.supermercado.caixasupermercadospring.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@AllArgsConstructor
@Data
public class ProdutoDto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private LocalDate dataDeValidade;

    public ProdutoDto(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        this.dataDeValidade = produto.getDataDeValidade();
    }
}
