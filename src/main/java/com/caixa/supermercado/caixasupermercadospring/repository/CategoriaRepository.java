package com.caixa.supermercado.caixasupermercadospring.repository;

import com.caixa.supermercado.caixasupermercadospring.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
