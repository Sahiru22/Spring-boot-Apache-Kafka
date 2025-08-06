package com.example.Spring_boot_order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OrderEventDTO {

  private String message;
  private String status;
}
