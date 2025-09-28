package com.quoteExpress.quoteExpress.DTO;

public class Product {

    private String description;

    private Integer quantite;

    private char unite = '€';

    private Double unitaryPrice;

    private Double tva;

    private Double totalPrice;

    public Product(String description, Integer quantite, char unite, Double unitaryPrice, Double tva, Double totalPrice) {
        this.description = description;
        this.quantite = quantite;
        this.unite = unite;
        this.unitaryPrice = unitaryPrice;
        this.tva = tva;
        this.totalPrice = totalPrice;
    }

    public Product() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public char getUnite() {
        return unite;
    }

    public void setUnite(char unite) {
        this.unite = unite;
    }

    public Double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(Double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
