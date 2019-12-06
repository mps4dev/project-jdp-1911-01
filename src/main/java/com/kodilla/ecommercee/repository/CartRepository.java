package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartNotFoundException;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Override
    List<Cart> findAll();

    Optional<Cart> findById(long id);

    @Override
    Cart save(Cart cart);

    default Cart findOrThrow(long id) throws CartNotFoundException {
        Cart cart = findById(id).orElseThrow(CartNotFoundException::new);
        return cart;
    }

    void deleteById(long id);
}
