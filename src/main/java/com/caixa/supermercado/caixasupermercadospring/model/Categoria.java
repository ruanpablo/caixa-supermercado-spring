package com.caixa.supermercado.caixasupermercadospring.model;

import com.caixa.supermercado.caixasupermercadospring.dto.CategoriaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public static List<CategoriaDto> conversorParaListaDto(List<Categoria> categorias){
        List<CategoriaDto> dto = new ArrayList<>();
        categorias.forEach(c -> dto.add(new CategoriaDto(c.getNome())));
        return dto;
    }

}
