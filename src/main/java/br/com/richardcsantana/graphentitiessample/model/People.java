package br.com.richardcsantana.graphentitiessample.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@EqualsAndHashCode(exclude = "name")
@AllArgsConstructor
public class People {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final Long id;

    private final String name;

}
