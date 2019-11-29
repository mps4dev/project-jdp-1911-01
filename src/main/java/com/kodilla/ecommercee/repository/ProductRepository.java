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

    Optional<Product> findById(Long id);

    default Optional<Product> findOrThrow(Long id) throws ProductNotFoundException {
        Optional<Product> product = Optional.ofNullable(findById(id).orElseThrow(ProductNotFoundException::new));
        return product;
    }

    void deleteById(Long id);
}
