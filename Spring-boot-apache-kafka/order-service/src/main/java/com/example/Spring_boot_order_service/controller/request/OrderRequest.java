package com.example.Spring_boot_order_service.controller.request;

import lombok.Data;

@Data
public class OrderRequest {

  private Long id;
  private String orderDate;
  private Integer amount;
}
