package com.pedido2.domain.repository.criteria;

import com.pedido2.domain.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProdutoCriteriaImpl implements ProdutoCriteria {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Produto> findByNameCrit(String name) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> root = cq.from(Produto.class);

        cq.select(root);
        if (name != null) {
            cq.where(cb.like(root.get("nome"), "%" + name + "%"));
        }

        TypedQuery<Produto> query = this.entityManager.createQuery(cq);
        return query.getResultList();
    }
}
