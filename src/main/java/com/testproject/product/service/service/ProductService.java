package com.testproject.product.service.service;

import com.testproject.product.service.dto.ProductDto;

import java.util.List;

public interface ProductService {

    String createDataProduct(ProductDto productDto);

    List<ProductDto> listProduct();
}
