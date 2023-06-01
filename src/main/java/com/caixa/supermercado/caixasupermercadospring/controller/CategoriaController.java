package com.caixa.supermercado.caixasupermercadospring.controller;

import com.caixa.supermercado.caixasupermercadospring.dto.CategoriaDto;
import com.caixa.supermercado.caixasupermercadospring.model.Categoria;
import com.caixa.supermercado.caixasupermercadospring.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("list")
    public List<CategoriaDto> listarCategorias(){
        return Categoria.conversorParaListaDto(categoriaRepository.findAll());
    }
}
