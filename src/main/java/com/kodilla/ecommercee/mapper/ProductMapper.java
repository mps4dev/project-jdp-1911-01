package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
        return productDto;
    }

    public Product mapToProduct(ProductDto productDto) {
        Product product = new Product(
                0L,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
        return product;
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getName(), product.getDescription(), product.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(List<ProductDto> dtoProducts) {
        return dtoProducts.stream()
                .map(product -> new Product(0L, product.getName(), product.getDescription(), product.getPrice()))
                .collect(Collectors.toList());
    }
}
