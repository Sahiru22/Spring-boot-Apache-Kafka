package com.example.product_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

  @Id
  private Long id;
  private Long productId;
  private String productName;
  private String description;
}