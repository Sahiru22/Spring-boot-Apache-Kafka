package com.example.Spring_boot_order_service.service;

import com.example.Spring_boot_order_service.controller.request.OrderRequest;
import com.example.Spring_boot_order_service.dto.OrderDTO;
import com.example.Spring_boot_order_service.model.Order;
import java.util.List;

public interface OrderService {

  List<OrderDTO> getAllOrders();

  OrderDTO getOrderById(Long id);

  Order saveOrder(OrderRequest request);
}
