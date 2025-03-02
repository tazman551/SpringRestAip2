package com.elderwood.restapi.controller;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductController {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="productID")
    private Long ID;
    @Column(nullable = false) 
    private String title;
    @Column(nullable = false) 
    private BigDecimal price;
    private String description;
    @Column(nullable = false, columnDefinition = "boolean false") 
    private boolean discountable;
    @Column(nullable = false, columnDefinition = "int default 0") 
    private int quantity;
    private String imgPath;
    
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isDiscountable() {
        return discountable;
    }
    public void setDiscountable(boolean discountable) {
        this.discountable = discountable;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    

}
