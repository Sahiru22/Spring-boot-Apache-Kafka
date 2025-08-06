package com.example.Spring_boot_order_service.controller;

import com.example.Spring_boot_order_service.dto.OrderDTO;
import com.example.Spring_boot_order_service.dto.OrderEventDTO;
import com.example.Spring_boot_order_service.model.Order;
import com.example.Spring_boot_order_service.producer.OrderProducer;
import com.example.Spring_boot_order_service.service.OrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;
  private final OrderProducer orderProducer;

  @GetMapping("")
  public List<OrderDTO> getOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/{id}")
  public OrderDTO getOrderById(@PathVariable Integer id) {
    return orderService.getOrderById(id);
  }

  @PostMapping("")
  public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO) {
    Order savedOrder = orderService.saveOrder(orderDTO);

    OrderEventDTO orderEventDTO = new OrderEventDTO();
    orderEventDTO.setMessage("Order Created with ID: " + savedOrder.getId());
    orderEventDTO.setStatus("PENDING");
    orderProducer.sendMessage(orderEventDTO);

    return orderDTO;
  }
}
