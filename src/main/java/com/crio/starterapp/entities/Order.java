package com.crio.starterapp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    private String id;
    private Date orderDate;
    private Double totalPrice;

    @ManyToMany
    @JoinTable(
            name = "order_groceryitem",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_item_id")
    )
    private List<GroceryItem> groceryItemList;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}