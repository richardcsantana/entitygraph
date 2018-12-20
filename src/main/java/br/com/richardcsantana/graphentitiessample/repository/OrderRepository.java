package br.com.richardcsantana.graphentitiessample.repository;

import br.com.richardcsantana.graphentitiessample.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Override
    @EntityGraph(value = "graph.Order.products", type = EntityGraph.EntityGraphType.LOAD)
    Page<Order> findAll(Pageable pageable);

    @EntityGraph(value = "graph.Order.products", type = EntityGraph.EntityGraphType.LOAD)
    Page<Order> findByItemsProductActiveFalse(Pageable pageable);

    @EntityGraph(value = "graph.Order.products", type = EntityGraph.EntityGraphType.LOAD)
    Page<Order> findByItemsProductActiveFalseAndServicesServiceActiveFalse(Pageable pageable);

}
