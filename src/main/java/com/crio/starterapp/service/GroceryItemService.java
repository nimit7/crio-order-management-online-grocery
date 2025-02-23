package com.crio.starterapp.service;

import com.crio.starterapp.entities.GroceryItem;
import com.crio.starterapp.exception.ResourceNotFoundException;
import com.crio.starterapp.repository.GroceryItemRepository;

import java.util.List;

public class GroceryItemService {
    private final GroceryItemRepository groceryItemRepository;

    public GroceryItemService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Grocery item not found for id " + id));
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedGroceryItem) {
        GroceryItem existingGroceryItem = getGroceryItemById(id);

        existingGroceryItem.setName(updatedGroceryItem.getName());
        existingGroceryItem.setCategory(updatedGroceryItem.getCategory());
        existingGroceryItem.setPrice(updatedGroceryItem.getPrice());

        return groceryItemRepository.save(updatedGroceryItem);
    }

    public void deleteGroceryItem(Long id) {
        GroceryItem groceryItemToDelete = getGroceryItemById(id);
        groceryItemRepository.delete(groceryItemToDelete);
    }
}
