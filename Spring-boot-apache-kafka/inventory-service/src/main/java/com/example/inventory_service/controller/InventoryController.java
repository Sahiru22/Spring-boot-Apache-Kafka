package com.example.inventory_service.controller;

import com.example.inventory_service.Service.InventoryService;
import com.example.inventory_service.controller.request.InventoryRequest;
import com.example.inventory_service.dto.InventoryDTO;
import com.example.inventory_service.model.Inventory;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/inventories")
public class InventoryController {

  private final InventoryService inventoryService;

  @GetMapping("")
  public List<InventoryDTO> getInventories() {
    return inventoryService.getAllInventories();
  }

  @GetMapping("/{id}")
  public InventoryDTO getInventoryById(@PathVariable Long id) {
    return inventoryService.getInventoryById(id);
  }

  @PostMapping("")
  public Inventory saveInventory(@RequestBody InventoryRequest request) {
    return inventoryService.saveInventory(request);
  }

}
