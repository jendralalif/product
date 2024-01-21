package com.testproject.product.service.service.impl;

import com.testproject.product.service.dto.ProductDto;
import com.testproject.product.service.model.ProductModel;
import com.testproject.product.service.repository.ProductRepository;
import com.testproject.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;
    @Override
    public String createDataProduct(ProductDto productDto) {

        // Set data from data request object to model object
        ProductModel productModel = ProductModel.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .build();

        // save data from data request to database
        productRepo.save(productModel);
        return "success";
    }

    @Override
    public List<ProductDto> listProduct() {

        // Get all data product from database
        List<ProductModel> listDataProduct = productRepo.findAll();

        // Set all data from database to list data transfer object
        List<ProductDto> listDataProductDto = new ArrayList<ProductDto>();
        for(ProductModel productModel : listDataProduct) {

            ProductDto productDto = ProductDto.builder()
                    .id(productModel.getId())
                    .name(productModel.getName())
                    .price(productModel.getPrice())
                    .description(productModel.getDescription())
                    .build();

            listDataProductDto.add(productDto);

        }
        return listDataProductDto;
    }
}
