package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductTestSuite {

    @Autowired
    private ProductService productService;

    @Test
    public void addProductTest() {
        //Given
        ProductDto product = new ProductDto();

        //When
        productService.create(product);

        //Then
        Assert.assertEquals(1, productService.getAll().size());
    }

    @Test
    public void deleteProductTest() {
        //Given
        ProductDto product = new ProductDto();
        ProductDto product2 = new ProductDto();

        //When
        productService.create(product);
        productService.create(product2);
        productService.delete(2L);

        //Then
        Assert.assertEquals(1, productService.getAll().size());
    }
}
