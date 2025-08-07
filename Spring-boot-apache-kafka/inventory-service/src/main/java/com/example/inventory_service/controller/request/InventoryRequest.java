package com.example.inventory_service.controller.request;

import lombok.Data;

@Data
public class InventoryRequest {

  private Long id;
  private Long itemId;
  private Long productId;
  private Integer quantity;

}
