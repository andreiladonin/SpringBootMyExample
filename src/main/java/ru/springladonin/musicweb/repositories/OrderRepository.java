package ru.springladonin.musicweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springladonin.musicweb.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
