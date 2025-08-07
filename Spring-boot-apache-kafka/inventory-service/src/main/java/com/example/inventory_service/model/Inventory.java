package com.example.inventory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "inventories")
public class Inventory {

  @Id
  private Long id;
  private Long itemId;
  private Long productId;
  private Integer quantity;

}
