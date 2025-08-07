package com.example.inventory_service.dto;

import lombok.Data;

@Data
public class OrderEventDTO {

  private String message;
  private String status;
}
