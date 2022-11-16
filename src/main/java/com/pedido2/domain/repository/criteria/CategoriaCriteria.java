package com.pedido2.domain.repository.criteria;

import com.pedido2.domain.entity.CategoriaProduto;

import java.util.List;

public interface CategoriaCriteria {
    List<CategoriaProduto> findByNameCrit(String nome);

    CategoriaProduto findByIdCrit(Integer id);
}
