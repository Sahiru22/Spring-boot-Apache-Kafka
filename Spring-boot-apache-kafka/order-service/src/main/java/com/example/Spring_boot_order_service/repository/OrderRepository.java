package com.example.Spring_boot_order_service.repository;

import com.example.Spring_boot_order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
