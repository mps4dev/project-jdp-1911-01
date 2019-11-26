package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToProductDto(Product product) {
        return Optional.of(new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice())).orElse(null);
    }

    public Product mapToProduct(ProductDto productDto) {
        return Optional.of(new Product(
                0L,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice())).orElse(null);
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(List<ProductDto> dtoProducts) {
        return dtoProducts.stream()
                .map(product -> new Product(0L, product.getName(), product.getDescription(), product.getPrice()))
                .collect(Collectors.toList());
    }
}
