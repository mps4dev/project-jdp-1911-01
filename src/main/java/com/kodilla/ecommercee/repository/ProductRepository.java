package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    Optional<Product> findById(long id);

    default Product findOrThrow(long id) throws ProductNotFoundException {
        Product product = findById(id).orElseThrow(ProductNotFoundException::new);
        return product;
    }

    void deleteById(long id);
}