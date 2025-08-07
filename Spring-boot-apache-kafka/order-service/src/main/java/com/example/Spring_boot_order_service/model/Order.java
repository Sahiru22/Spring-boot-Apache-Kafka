package com.example.Spring_boot_order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

  @Id
  private Long id;

  private LocalDate orderDate;

  private Integer amount;

}
