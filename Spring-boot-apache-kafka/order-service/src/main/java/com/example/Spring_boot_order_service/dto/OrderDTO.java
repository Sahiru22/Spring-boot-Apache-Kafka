package com.example.Spring_boot_order_service.dto;

import lombok.Data;

@Data
public class OrderDTO {

  private Long id;
  private String orderDate;
  private Integer amount;

}
