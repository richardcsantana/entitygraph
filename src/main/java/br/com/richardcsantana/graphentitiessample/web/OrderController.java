package br.com.richardcsantana.graphentitiessample.web;

import br.com.richardcsantana.graphentitiessample.model.Order;
import br.com.richardcsantana.graphentitiessample.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping
    public Page<Order> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @GetMapping(path = "/filtered")
    public Page<Order> getAllFiltered(Pageable pageable) {
        return orderRepository.findByItemsProductActiveFalseAndServicesServiceActiveFalse(pageable);
    }

    @GetMapping(path = "/{id}")
    public Order getById(@PathVariable(name = "id") Long id) {
        return orderRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @PutMapping(path = "/{id}")
    public Order update(@RequestParam(name = "id") Long id, Order order) {
        Order persisted = orderRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        BeanUtils.copyProperties(order, persisted, "id");
        return orderRepository.save(persisted);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        Order persisted = orderRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        orderRepository.delete(persisted);
    }
}
