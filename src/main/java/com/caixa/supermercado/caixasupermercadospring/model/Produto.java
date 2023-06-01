package com.caixa.supermercado.caixasupermercadospring.model;

import com.caixa.supermercado.caixasupermercadospring.dto.ProdutoDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoDeBarras;
    private int quantidadeEmEstoque;
    private double preco;
    private LocalDate dataDeValidade;
    @ManyToOne
    private Categoria categoria;

    public Produto(String nome, int quantidadeEmEstoque, double preco, LocalDate dataDeValidade, Categoria byNome) {
    }

    public static List<ProdutoDto> conversorDeLista(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
    }
}
