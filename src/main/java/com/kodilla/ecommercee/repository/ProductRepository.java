package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericEntityRepository<Product> {
}