package com.example.product_service.service.impl;

import com.example.product_service.controller.request.ProductRequest;
import com.example.product_service.dto.ProductDTO;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public List<ProductDTO> getAllProducts() {
    return productRepository.findAll().stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public ProductDTO getProductById(Long id) {
    return productRepository.findById(id)
        .map(this::toDTO)
        .orElse(null);
  }

  @Override
  public Product saveProduct(ProductRequest request) {
    Product product = new Product();
    product.setId(request.getId());
    product.setProductId(request.getProductId());
    product.setProductName(request.getProductName());
    product.setDescription(request.getDescription());

    return productRepository.save(product);
  }

  private ProductDTO toDTO(Product product) {
    ProductDTO dto = new ProductDTO();
    dto.setId(product.getId());
    dto.setProductId(product.getProductId());
    dto.setProductName(product.getProductName());
    dto.setDescription(product.getDescription());
    return dto;
  }
}
