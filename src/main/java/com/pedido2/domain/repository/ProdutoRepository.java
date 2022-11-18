package com.pedido2.domain.repository;

import com.pedido2.domain.entity.Produto;
import com.pedido2.domain.repository.criteria.ProdutoCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>, ProdutoCriteria {
    @Query("SELECT p FROM Produto p where p.nome LIKE %:nome%")
    public List<Produto> searchbyNome(@Param("nome") String nome);
}
