package com.example.Spring_boot_order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {

  @Id
  private Long id;

  private String orderDate;

  private Integer amount;

}
