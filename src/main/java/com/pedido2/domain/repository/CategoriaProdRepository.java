package com.pedido2.domain.repository;

import com.pedido2.domain.entity.CategoriaProduto;
import com.pedido2.domain.repository.criteria.CategoriaCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaProdRepository extends JpaRepository<CategoriaProduto, Integer>, CategoriaCriteria {

    @Query("SELECT cp from CategoriaProduto cp WHERE cp.nome LIKE %:name%")
    List<CategoriaProduto> findByName(@Param("name") String nome);

}
