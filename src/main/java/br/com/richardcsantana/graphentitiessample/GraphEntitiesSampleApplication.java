package br.com.richardcsantana.graphentitiessample;

import br.com.richardcsantana.graphentitiessample.model.*;
import br.com.richardcsantana.graphentitiessample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GraphEntitiesSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphEntitiesSampleApplication.class, args);
    }

    @Autowired
    private OrderRepository orderRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Set items = new HashSet<>(
                    Arrays.asList(
                            new OrderItem(null, 0, 1, new Product(null,0,"teste",true)),
                            new OrderItem(null, 0, 1, new Product(null,0,"teste",false))
                    )
            );
            Set services = new HashSet<>(
                    Arrays.asList(
                            new OrderService(1, new Service("teste",true)),
                            new OrderService(1, new Service("teste",false))
                    )
            );
            Order order = new Order(null, 0, "10", items,services);
            orderRepository.save(order);
            items = new HashSet<>(
                    Arrays.asList(
                            new OrderItem(null, 0, 1, new Product( null,0,"teste",true)),
                            new OrderItem(null, 0, 1, new Product( null,0,"teste",false))
                    )
            );
            services = new HashSet<>(
                    Arrays.asList(
                            new OrderService(1, new Service("teste",true)),
                            new OrderService(1, new Service("teste",false))
                    )
            );
            order = new Order(null, 0, "10", items, services);
            orderRepository.save(order);
        };
    }

}

