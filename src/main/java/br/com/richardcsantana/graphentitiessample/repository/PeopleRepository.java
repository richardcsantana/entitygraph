package br.com.richardcsantana.graphentitiessample.repository;

import br.com.richardcsantana.graphentitiessample.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
