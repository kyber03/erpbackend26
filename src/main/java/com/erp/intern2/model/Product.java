package com.erp.intern2.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    private String SKU;

    private String category;

    private double price;

    private int quantities_avl;

    private int reorder_level;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SKU='" + SKU + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantities_avl=" + quantities_avl +
                ", reorder_level=" + reorder_level +
                '}';
    }

}
