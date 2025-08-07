package com.example.Spring_boot_order_service.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class OrderDTO {

  private Long id;
  private LocalDate orderDate;
  private Integer amount;

}
