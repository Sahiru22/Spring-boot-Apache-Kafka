package com.example.inventory_service.Service;

import com.example.inventory_service.controller.request.InventoryRequest;
import com.example.inventory_service.dto.InventoryDTO;
import com.example.inventory_service.model.Inventory;
import java.util.List;

public interface InventoryService {

  List<InventoryDTO> getAllInventories();

  InventoryDTO getInventoryById(Long id);

  Inventory saveInventory(InventoryRequest request);
}
