package com.example.Spring_boot_order_service.service.impl;

import com.example.Spring_boot_order_service.controller.request.OrderRequest;
import com.example.Spring_boot_order_service.dto.OrderDTO;
import com.example.Spring_boot_order_service.model.Order;
import com.example.Spring_boot_order_service.repository.OrderRepository;
import com.example.Spring_boot_order_service.service.OrderService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public List<OrderDTO> getAllOrders() {
    return orderRepository.findAll().stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public OrderDTO getOrderById(Long id) {
    return orderRepository.findById(id)
        .map(this::toDTO)
        .orElse(null);
  }

  @Override
  public Order saveOrder(OrderRequest request) {
    Order order = new Order();
    order.setId(request.getId());
    order.setOrderDate(request.getOrderDate());
    order.setAmount(request.getAmount());

    return orderRepository.save(order);
  }

  private OrderDTO toDTO(Order order) {
    OrderDTO dto = new OrderDTO();
    dto.setId(order.getId());
    dto.setOrderDate(order.getOrderDate());
    dto.setAmount(order.getAmount());
    return dto;
  }
}
