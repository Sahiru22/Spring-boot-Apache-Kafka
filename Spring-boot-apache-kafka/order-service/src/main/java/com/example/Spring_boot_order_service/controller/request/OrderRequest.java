package com.example.Spring_boot_order_service.controller.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class OrderRequest {

  private Long id;
  private LocalDate orderDate;
  private Integer amount;
}
