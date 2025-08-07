package com.example.product_service.controller.request;

import lombok.Data;

@Data
public class ProductRequest {

  private Long id;
  private Long productId;
  private String productName;
  private String description;

}
