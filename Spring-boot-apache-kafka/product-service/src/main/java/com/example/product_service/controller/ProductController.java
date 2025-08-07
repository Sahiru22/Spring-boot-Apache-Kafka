package com.example.product_service.controller;

import com.example.product_service.controller.request.ProductRequest;
import com.example.product_service.dto.ProductDTO;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("")
  public List<ProductDTO> getProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public ProductDTO getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PostMapping("")
  public Product saveProduct(@RequestBody ProductRequest request) {
    return productService.saveProduct(request);
  }
}
