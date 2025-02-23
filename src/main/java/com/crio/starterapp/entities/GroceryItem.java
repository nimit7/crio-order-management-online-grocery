package com.crio.starterapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GroceryItem {
    @Id
    private Long id;
    private String name;
    private String category;
    private int price;
}