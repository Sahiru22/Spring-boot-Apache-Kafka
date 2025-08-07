package com.example.product_service.dto;

import lombok.Data;

@Data
public class ProductDTO {

  private Long id;
  private Long productId;
  private String productName;
  private String description;

}
