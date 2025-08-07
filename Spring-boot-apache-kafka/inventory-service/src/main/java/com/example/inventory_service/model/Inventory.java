package com.example.inventory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Inventory {

  @Id
  private Long id;
  private Long itemId;
  private Long productId;
  private Integer quantity;

}
