package com.pedido2.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataPedido;

    @OneToMany(mappedBy = "pedido")
    List<ItemPedido> itens;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    private LocalDate dataEntregaPrevista;




}
