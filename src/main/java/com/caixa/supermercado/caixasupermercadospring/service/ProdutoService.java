package com.caixa.supermercado.caixasupermercadospring.service;

import com.caixa.supermercado.caixasupermercadospring.config.validation.ValidationException;
import com.caixa.supermercado.caixasupermercadospring.dto.ProdutoDto;
import com.caixa.supermercado.caixasupermercadospring.form.AtualizaProdutoForm;
import com.caixa.supermercado.caixasupermercadospring.form.ProdutoForm;
import com.caixa.supermercado.caixasupermercadospring.model.Produto;
import com.caixa.supermercado.caixasupermercadospring.repository.CategoriaRepository;
import com.caixa.supermercado.caixasupermercadospring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProdutoDto> list(String nomeCategoria) throws ValidationException{
        if (nomeCategoria == null) {
            return Produto.conversorDeLista(produtoRepository.findAll());
        } else {
            return validFindNome(produtoRepository.findByCategoriaNome(nomeCategoria));
        }
    }

    private List<ProdutoDto> validFindNome(List<Produto> list) throws ValidationException{
        if (list.isEmpty()){
        throw new ValidationException("Nome da categoria não encontrado em nossa base de dados");
        }
        return Produto.conversorDeLista(list);
    }

    public ProdutoDto findId(Long id) throws ValidationException{
        if (produtoRepository.existsById(id)) {
            return new ProdutoDto(produtoRepository.findById(id).get());
        }
        throw new ValidationException("Id não encontrado em nossa base de dados");
    }

    public ProdutoDto cadastrarProduto(ProdutoForm form) throws ValidationException {
        if (Objects.isNull(categoriaRepository.findByNome(form.getNomeCategoria()))){
            throw new ValidationException("Nome da Categoria não encontrado em nossa base de dados");
        }
        return new ProdutoDto(produtoRepository.save(form.conversor(categoriaRepository)));
    }


    public ProdutoDto atualizarProduto(AtualizaProdutoForm form, Long id) throws ValidationException {
        if (produtoRepository.existsById(id)) {
            return new ProdutoDto(produtoRepository.save(form.converter()));
        }
        throw new ValidationException("Id do produto não encontrado");
    }

    public void deletarProduto(Long id) throws ValidationException{
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
        throw new ValidationException("Não existe id naa nossa base de dados");
    }
}
