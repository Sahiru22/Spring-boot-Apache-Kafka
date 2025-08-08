package com.example.Spring_boot_order_service.controller;

import com.example.Spring_boot_order_service.controller.request.OrderRequest;
import com.example.Spring_boot_order_service.dto.OrderDTO;
import com.example.Spring_boot_order_service.model.Order;
import com.example.Spring_boot_order_service.producer.OrderProducer;
import com.example.Spring_boot_order_service.service.OrderService;
import com.example.common.dto.OrderEventDTO;
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
  public OrderDTO getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }

  @PostMapping("")
  public OrderDTO saveOrder(@RequestBody OrderRequest request) {
    Order savedOrder = orderService.saveOrder(request);

    OrderEventDTO orderEventDTO = new OrderEventDTO();
    orderEventDTO.setMessage("Order Created with ID: " + savedOrder.getId());
    orderEventDTO.setStatus("PENDING");
    orderProducer.sendMessage(orderEventDTO);
    return mapOrderToOrderDTO(savedOrder);
  }

  private OrderDTO mapOrderToOrderDTO(Order order) {
    OrderDTO dto = new OrderDTO();
    dto.setId(order.getId());
    return dto;
  }
}
