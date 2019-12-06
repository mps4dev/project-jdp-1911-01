package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductTestSuite {

    @Autowired
    private ProductService productService;

    @Test
    public void addProductTest() throws ProductNotFoundException {
        //Given
        ProductDto product = new ProductDto();

        //When
        productService.saveProduct(product);

        //Then
        Assert.assertEquals(1, productService.getProducts().size());
    }

    @Test
    public void deleteProductTest() throws ProductNotFoundException {
        //Given
        ProductDto product = new ProductDto();
        ProductDto product2 = new ProductDto();

        //When
        productService.saveProduct(product);
        productService.saveProduct(product2);
        productService.deleteProductById(2L);

        //Then
        Assert.assertEquals(1, productService.getProducts().size());
    }
}
