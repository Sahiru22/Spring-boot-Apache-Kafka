package com.example.product_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

  @Id
  private Long id;
  private Long productId;
  private String productName;
  private String description;
}