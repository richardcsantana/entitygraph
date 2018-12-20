package br.com.richardcsantana.graphentitiessample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchaseOrder")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "graph.Order.products",
        attributeNodes = {
                @NamedAttributeNode(value = "items", subgraph = "items"),
                @NamedAttributeNode(value = "services", subgraph = "services")
        },
        subgraphs = {
                @NamedSubgraph(name = "items", attributeNodes = @NamedAttributeNode("product")),
                @NamedSubgraph(name = "services", attributeNodes = @NamedAttributeNode("service"))
        })
public class Order implements Serializable {

    private static final long serialVersionUID = -762249738490222396L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;
    @Version
    @Column(name = "version")
    private int version = 0;

    @Column
    private String orderNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> items = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderService> services = new HashSet<>();
}
