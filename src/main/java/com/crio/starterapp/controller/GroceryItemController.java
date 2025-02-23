package com.crio.starterapp.controller;

import com.crio.starterapp.entities.GroceryItem;
import com.crio.starterapp.service.GroceryItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grocery-items")
public class GroceryItemController {
    private final GroceryItemService groceryItemService;

    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @PostMapping
    public ResponseEntity<GroceryItem> createGroceryItem(@RequestBody GroceryItem savedGroceryItem) {
        GroceryItem groceryItem = groceryItemService.createGroceryItem(savedGroceryItem);
        return ResponseEntity.ok(groceryItem);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        List<GroceryItem> groceryItemList = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItemList);
    }

    @GetMapping("{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long id) {
        GroceryItem groceryItem = groceryItemService.getGroceryItemById(id);
        return ResponseEntity.ok(groceryItem);
    }

    @PutMapping("{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem updatedGroceryItem) {
        GroceryItem groceryItem = groceryItemService.updateGroceryItem(id, updatedGroceryItem);
        return ResponseEntity.ok(groceryItem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.ok().body("Grocery item deleted successfully");
    }
}
