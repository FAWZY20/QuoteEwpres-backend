package com.quoteExpress.quoteExpress.sevice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quoteExpress.quoteExpress.DTO.Product;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter(autoApply = true) // <- très important
public class ProductListConverter implements AttributeConverter<List<Product>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Product> productList) {
        if (productList == null) return "[]";
        try {
            return objectMapper.writeValueAsString(productList);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert list to JSON", e);
        }
    }

    @Override
    public List<Product> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return List.of();
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<Product>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to list", e);
        }
    }
}
