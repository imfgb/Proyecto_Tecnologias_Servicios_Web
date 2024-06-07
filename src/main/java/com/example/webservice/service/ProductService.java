package com.example.webservice.service;

import com.example.webservice.dto.ProductDTO;
import com.example.webservice.entity.Product;
import com.example.webservice.entity.UnitMeasure;
import com.example.webservice.entity.ProductSubcategory;
import com.example.webservice.entity.ProductModel;
import com.example.webservice.repository.ProductRepository;
import com.example.webservice.repository.UnitMeasureRepository;
import com.example.webservice.repository.ProductSubcategoryRepository;
import com.example.webservice.repository.ProductModelRepository;
import com.example.webservice.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UnitMeasureRepository unitMeasureRepository;
    private final ProductSubcategoryRepository productSubcategoryRepository;
    private final ProductModelRepository productModelRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, UnitMeasureRepository unitMeasureRepository,
                          ProductSubcategoryRepository productSubcategoryRepository, ProductModelRepository productModelRepository) {
        this.productRepository = productRepository;
        this.unitMeasureRepository = unitMeasureRepository;
        this.productSubcategoryRepository = productSubcategoryRepository;
        this.productModelRepository = productModelRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findByIdWithJoins(id);
    }

    public List<ProductDTO> findByProductSubcategoryId(int subcategoryId) {
        return productRepository.findByProductSubcategoryId(subcategoryId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Product save(Product product) throws Exception {
        Optional<Product> existingProduct = productRepository.findByProductNumber(product.getProductNumber());
        if (existingProduct.isPresent() && existingProduct.get().getProductId() != product.getProductId()) {
            throw new Exception("A product with the same ProductNumber already exists.");
        }
        return productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> findAllDTOs() {
        return productRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> findDTOById(int id) {
        return productRepository.findByIdWithJoins(id)
                .map(this::convertToDto);
    }

    public Product update(Product product) throws Exception {
        if (!productRepository.existsById(product.getProductId())) {
            throw new Exception("Product not found.");
        }
        return productRepository.save(product);
    }

    public ProductDTO convertToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setName(StringUtil.sanitize(product.getName()));
        dto.setProductNumber(StringUtil.sanitize(product.getProductNumber()));
        dto.setMakeFlag(product.isMakeFlag());
        dto.setFinishedGoodsFlag(product.isFinishedGoodsFlag());
        dto.setColor(StringUtil.sanitize(product.getColor()));
        dto.setSafetyStockLevel(product.getSafetyStockLevel());
        dto.setReorderPoint(product.getReorderPoint());
        dto.setStandardCost(product.getStandardCost());
        dto.setListPrice(product.getListPrice());
        dto.setSize(StringUtil.sanitize(product.getSize()));
        dto.setSizeUnitMeasureCode(product.getSizeUnitMeasure() != null ? product.getSizeUnitMeasure().getUnitMeasureCode() : null);
        dto.setWeightUnitMeasureCode(product.getWeightUnitMeasure() != null ? product.getWeightUnitMeasure().getUnitMeasureCode() : null);
        dto.setWeight(product.getWeight());
        dto.setDaysToManufacture(product.getDaysToManufacture());
        dto.setProductLine(StringUtil.sanitize(product.getProductLine()));
        dto.setClazz(StringUtil.sanitize(product.getClazz()));
        dto.setStyle(StringUtil.sanitize(product.getStyle()));
        dto.setProductSubcategoryId(product.getProductSubcategory() != null ? product.getProductSubcategory().getProductSubcategoryId() : null);
        dto.setSubcategoryName(StringUtil.sanitize(product.getProductSubcategory() != null ? product.getProductSubcategory().getName() : null));
        dto.setProductModelId(product.getProductModel() != null ? product.getProductModel().getProductModelId() : null);
        dto.setProductModelName(StringUtil.sanitize(product.getProductModel() != null ? product.getProductModel().getName() : null));
        dto.setSellStartDate(product.getSellStartDate());
        dto.setSellEndDate(product.getSellEndDate());
        dto.setDiscontinuedDate(product.getDiscontinuedDate());
        dto.setRowguid(product.getRowguid());
        dto.setModifiedDate(product.getModifiedDate());
        return dto;
    }

    public Product convertToEntity(ProductDTO dto) throws Exception {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setName(StringUtil.sanitize(dto.getName()));
        product.setProductNumber(dto.getProductNumber());
        product.setMakeFlag(dto.isMakeFlag());
        product.setFinishedGoodsFlag(dto.isFinishedGoodsFlag());
        product.setColor(dto.getColor());
        product.setSafetyStockLevel(dto.getSafetyStockLevel());
        product.setReorderPoint(dto.getReorderPoint());
        product.setStandardCost(dto.getStandardCost());
        product.setListPrice(dto.getListPrice());
        product.setSize(dto.getSize());

        if (dto.getSizeUnitMeasureCode() != null) {
            Optional<UnitMeasure> sizeUnitMeasure = unitMeasureRepository.findById(dto.getSizeUnitMeasureCode());
            if (sizeUnitMeasure.isPresent()) {
                product.setSizeUnitMeasure(sizeUnitMeasure.get());
            } else {
                throw new Exception("Invalid SizeUnitMeasureCode");
            }
        }

        if (dto.getWeightUnitMeasureCode() != null) {
            Optional<UnitMeasure> weightUnitMeasure = unitMeasureRepository.findById(dto.getWeightUnitMeasureCode());
            if (weightUnitMeasure.isPresent()) {
                product.setWeightUnitMeasure(weightUnitMeasure.get());
            } else {
                throw new Exception("Invalid WeightUnitMeasureCode");
            }
        }

        if (dto.getProductSubcategoryId() != null) {
            Optional<ProductSubcategory> productSubcategory = productSubcategoryRepository.findById(dto.getProductSubcategoryId());
            if (productSubcategory.isPresent()) {
                product.setProductSubcategory(productSubcategory.get());
            } else {
                throw new Exception("Invalid ProductSubcategoryId");
            }
        }

        if (dto.getProductModelId() != null) {
            Optional<ProductModel> productModel = productModelRepository.findById(dto.getProductModelId());
            if (productModel.isPresent()) {
                product.setProductModel(productModel.get());
            } else {
                throw new Exception("Invalid ProductModelId");
            }
        }

        product.setWeight(dto.getWeight());
        product.setDaysToManufacture(dto.getDaysToManufacture());
        product.setProductLine(dto.getProductLine());
        product.setClazz(dto.getClazz());
        product.setStyle(dto.getStyle());
        product.setSellStartDate(dto.getSellStartDate());
        product.setSellEndDate(dto.getSellEndDate());
        product.setDiscontinuedDate(dto.getDiscontinuedDate());
        product.setRowguid(dto.getRowguid());
        product.setModifiedDate(dto.getModifiedDate());
        return product;
    }
}
