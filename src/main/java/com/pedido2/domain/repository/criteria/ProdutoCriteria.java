package com.pedido2.domain.repository.criteria;

import com.pedido2.domain.entity.Produto;

import java.util.List;

public interface ProdutoCriteria {

    List<Produto> findByNameCrit(String name);
}
