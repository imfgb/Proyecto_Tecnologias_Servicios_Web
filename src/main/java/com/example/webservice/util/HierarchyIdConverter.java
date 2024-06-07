package com.example.webservice.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class HierarchyIdConverter implements AttributeConverter<String, byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(String attribute) {
        // Convert from String to byte array
        if (attribute == null) {
            return null;
        }
        return attribute.getBytes();
    }

    @Override
    public String convertToEntityAttribute(byte[] dbData) {
        // Convert from byte array to String
        if (dbData == null) {
            return null;
        }
        return new String(dbData);
    }
}
