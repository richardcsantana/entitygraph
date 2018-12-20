package br.com.richardcsantana.graphentitiessample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Service implements Serializable {
    private static final long serialVersionUID = 3754134442277446126L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private final Long id = null;

    @Version
    @Column(name = "version")
    private final int version = 0;

    @Column
    private String name;

    @Column
    private boolean active;
}
