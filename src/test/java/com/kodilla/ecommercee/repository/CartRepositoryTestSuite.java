package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CartRepositoryTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void shouldCreateNewCart() {
        //Given
        Cart cart = new Cart(1L, "test name", null, null);

        //When
        cartRepository.save(cart);

        //Then
        assertEquals(1,cartRepository.count());
    }

    @Test
    public void ShouldGetCart() {
        //Given
        Cart cart = new Cart(1L, "test name", null, null);

        //When
        cartRepository.save(cart);
        String savedName = cartRepository.findById(cart.getId()).get().getName();

        //Then
        assertEquals("test name",savedName);
    }

    @Test
    public void ShouldGetAllCarts() {
        //Given
        Cart cart1 = new Cart(1L, "test name 1", null, null);
        Cart cart2 = new Cart(2L, "test name 2", null, null);

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        List<Cart> carts = cartRepository.findAll();

        //Then
        assertEquals(2,carts.size());
    }

    @Test
    public void ShouldDeleteUser() {
        //Given
        Cart cart1 = new Cart(1L, "test name 1", null, null);
        Cart cart2 = new Cart(2L, "test name 2", null, null);

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        int repositorySize = cartRepository.findAll().size();
        cartRepository.deleteById(2L);
        int repositorySizeAfter = cartRepository.findAll().size();

        //Then
        assertEquals(2,repositorySize);
        assertEquals(1,repositorySizeAfter);
    }
}
