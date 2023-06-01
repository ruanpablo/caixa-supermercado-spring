package com.caixa.supermercado.caixasupermercadospring.controller;

import com.caixa.supermercado.caixasupermercadospring.config.validation.ValidationException;
import com.caixa.supermercado.caixasupermercadospring.dto.ProdutoDto;
import com.caixa.supermercado.caixasupermercadospring.form.AtualizaProdutoForm;
import com.caixa.supermercado.caixasupermercadospring.form.ProdutoForm;
import com.caixa.supermercado.caixasupermercadospring.model.Categoria;
import com.caixa.supermercado.caixasupermercadospring.model.Produto;
import com.caixa.supermercado.caixasupermercadospring.repository.CategoriaRepository;
import com.caixa.supermercado.caixasupermercadospring.repository.ProdutoRepository;
import com.caixa.supermercado.caixasupermercadospring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/list")
    public ResponseEntity<List<ProdutoDto>> listarProdutos(String nomeCategoria) throws ValidationException {
        return ResponseEntity.ok(produtoService.list(nomeCategoria));
    }

    @GetMapping("/findby/{id}")
    public ResponseEntity<ProdutoDto> buscarProdutoPorId(@PathVariable Long id) throws ValidationException {
        return ResponseEntity.ok(produtoService.findId(id));
    }

    @PostMapping("/register")
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid ProdutoForm form) throws ValidationException{
        return ResponseEntity.ok(produtoService.cadastrarProduto(form));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(Long id, @RequestBody @Valid AtualizaProdutoForm form) throws ValidationException{
        return ResponseEntity.ok(produtoService.atualizarProduto(form, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> detetarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok().build();
    }
}
