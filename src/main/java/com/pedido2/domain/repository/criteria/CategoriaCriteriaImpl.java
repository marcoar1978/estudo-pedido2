package com.pedido2.domain.repository.criteria;

import com.pedido2.domain.entity.CategoriaProduto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoriaCriteriaImpl implements CategoriaCriteria {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CategoriaProduto> findByNameCrit(String name) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoriaProduto> cq = cb.createQuery(CategoriaProduto.class);
        Root<CategoriaProduto> root = cq.from(CategoriaProduto.class);

        cq.select(root);
        if(name != null){
            cq.where(cb.like(root.get("nome"), "%"+name+"%"));
        }

        TypedQuery<CategoriaProduto> query = this.entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public CategoriaProduto findByIdCrit(Integer id) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoriaProduto> cq = cb.createQuery(CategoriaProduto.class);
        Root<CategoriaProduto> root = cq.from(CategoriaProduto.class);

        cq.select(root);
        cq.where(cb.equal(root.get("id"), id));

        TypedQuery<CategoriaProduto> query = this.entityManager.createQuery(cq);
        return query.getSingleResult();
    }


}
