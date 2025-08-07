package com.example.product_service.service;

import com.example.product_service.controller.request.ProductRequest;
import com.example.product_service.dto.ProductDTO;
import com.example.product_service.model.Product;
import java.util.List;

public interface ProductService {

  List<ProductDTO> getAllProducts();

  ProductDTO getProductById(Long id);

  Product saveProduct(ProductRequest request);
}
