package com.testproject.product.service.controller;

import com.testproject.product.service.dto.ProductDto;
import com.testproject.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/createProduct")
    public String createProduct(@RequestBody ProductDto productDto) {

        return productService.createDataProduct(productDto);
    }

    @GetMapping(value = "/getAllProduct")
    public List<ProductDto> getAllProduct() {

        return productService.listProduct();
    }

}
