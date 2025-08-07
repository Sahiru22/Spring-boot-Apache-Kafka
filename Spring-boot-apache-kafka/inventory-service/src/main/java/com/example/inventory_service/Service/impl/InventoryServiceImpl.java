package com.example.inventory_service.Service.impl;

import com.example.inventory_service.Service.InventoryService;
import com.example.inventory_service.controller.request.InventoryRequest;
import com.example.inventory_service.dto.InventoryDTO;
import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;

  @Override
  public List<InventoryDTO> getAllInventories() {
    return inventoryRepository.findAll().stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public InventoryDTO getInventoryById(Long id) {
    return inventoryRepository.findById(id)
        .map(this::toDTO)
        .orElse(null);
  }

  @Override
  public Inventory saveInventory(InventoryRequest request) {
    Inventory inventory = new Inventory();
    inventory.setId(request.getId());
    inventory.setProductId(request.getProductId());
    inventory.setItemId(request.getItemId());
    inventory.setQuantity(request.getQuantity());

    return inventoryRepository.save(inventory);
  }

  private InventoryDTO toDTO(Inventory inventory) {
    InventoryDTO dto = new InventoryDTO();
    dto.setId(inventory.getId());
    dto.setProductId(inventory.getProductId());
    dto.setItemId(inventory.getItemId());
    dto.setQuantity(inventory.getQuantity());
    return dto;
  }
}
