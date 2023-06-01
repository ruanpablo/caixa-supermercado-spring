package com.caixa.supermercado.caixasupermercadospring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carrinho {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valorTotalCompra;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<Produto> listaProdutos = new ArrayList<>();

}