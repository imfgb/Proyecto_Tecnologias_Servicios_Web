package com.example.webservice.controller;

import com.example.webservice.dto.UnitMeasureDTO;
import com.example.webservice.service.UnitMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unit-measures")
public class UnitMeasureController {
    private final UnitMeasureService unitMeasureService;

    @Autowired
    public UnitMeasureController(UnitMeasureService unitMeasureService) {
        this.unitMeasureService = unitMeasureService;
    }

    @GetMapping
    public List<UnitMeasureDTO> getAllUnitMeasures() {
        return unitMeasureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitMeasureDTO> getUnitMeasureById(@PathVariable String id) {
        return unitMeasureService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createUnitMeasure(@RequestBody UnitMeasureDTO unitMeasureDTO) {
        try {
            UnitMeasureDTO savedUnitMeasure = unitMeasureService.save(unitMeasureDTO);
            return ResponseEntity.ok(savedUnitMeasure);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnitMeasure(@PathVariable String id) {
        unitMeasureService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUnitMeasure(@PathVariable String id, @RequestBody UnitMeasureDTO unitMeasureDTO) {
        try {
            unitMeasureDTO.setUnitMeasureCode(id);
            UnitMeasureDTO updatedUnitMeasure = unitMeasureService.update(unitMeasureDTO);
            return ResponseEntity.ok(updatedUnitMeasure);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
