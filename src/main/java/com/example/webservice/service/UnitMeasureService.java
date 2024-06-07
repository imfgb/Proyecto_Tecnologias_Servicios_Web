package com.example.webservice.service;

import com.example.webservice.dto.UnitMeasureDTO;
import com.example.webservice.entity.UnitMeasure;
import com.example.webservice.repository.UnitMeasureRepository;
import com.example.webservice.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitMeasureService {
    private final UnitMeasureRepository unitMeasureRepository;

    @Autowired
    public UnitMeasureService(UnitMeasureRepository unitMeasureRepository) {
        this.unitMeasureRepository = unitMeasureRepository;
    }

    public List<UnitMeasureDTO> findAll() {
        return unitMeasureRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<UnitMeasureDTO> findById(String id) {
        return unitMeasureRepository.findById(id)
                .map(this::convertToDTO);
    }

    public UnitMeasureDTO save(UnitMeasureDTO unitMeasureDTO) {
        UnitMeasure unitMeasure = convertToEntity(unitMeasureDTO);
        UnitMeasure savedUnitMeasure = unitMeasureRepository.save(unitMeasure);
        return convertToDTO(savedUnitMeasure);
    }

    public void deleteById(String id) {
        unitMeasureRepository.deleteById(id);
    }

    public UnitMeasureDTO update(UnitMeasureDTO unitMeasureDTO) throws Exception {
        if (!unitMeasureRepository.existsById(unitMeasureDTO.getUnitMeasureCode())) {
            throw new Exception("UnitMeasure not found.");
        }

        // Set current date and time if modifiedDate is null
        if (unitMeasureDTO.getModifiedDate() == null) {
            unitMeasureDTO.setModifiedDate(LocalDateTime.now());
        }

        UnitMeasure unitMeasure = convertToEntity(unitMeasureDTO);
        UnitMeasure updatedUnitMeasure = unitMeasureRepository.save(unitMeasure);
        return convertToDTO(updatedUnitMeasure);
    }

    private UnitMeasureDTO convertToDTO(UnitMeasure unitMeasure) {
        UnitMeasureDTO dto = new UnitMeasureDTO();
        dto.setUnitMeasureCode(unitMeasure.getUnitMeasureCode());
        dto.setName(StringUtil.sanitize(unitMeasure.getName()));
        dto.setModifiedDate(unitMeasure.getModifiedDate());
        return dto;
    }

    private UnitMeasure convertToEntity(UnitMeasureDTO unitMeasureDTO) {
        UnitMeasure entity = new UnitMeasure();
        entity.setUnitMeasureCode(unitMeasureDTO.getUnitMeasureCode());
        entity.setName(StringUtil.sanitize(unitMeasureDTO.getName()));
        entity.setModifiedDate(unitMeasureDTO.getModifiedDate());
        return entity;
    }
}
