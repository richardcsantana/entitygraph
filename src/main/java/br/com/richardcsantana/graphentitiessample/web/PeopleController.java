package br.com.richardcsantana.graphentitiessample.web;

import br.com.richardcsantana.graphentitiessample.model.People;
import br.com.richardcsantana.graphentitiessample.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/people")
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleRepository peopleRepository;

    @GetMapping
    public Page<People> getAll(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Optional<People> getById(Long id){
        return peopleRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public People save(People people){
        return peopleRepository.save(people);
    }

    @PutMapping(path="/{id}")
    public People update(Long id, People people){
        People persisted = peopleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        BeanUtils.copyProperties(people,persisted,"id");
        return peopleRepository.save(persisted);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){
        People persisted = peopleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        peopleRepository.delete(persisted);
    }

}
