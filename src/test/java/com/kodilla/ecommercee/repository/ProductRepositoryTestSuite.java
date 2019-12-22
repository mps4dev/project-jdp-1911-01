package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class ProductRepositoryTestSuite {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private CartRepository cartRepository;

    @Test
    public void shouldCreateNewProduct() {
        //Given
        Product product = new Product(0L, "Test", "Test", new BigDecimal(2));

        //When
        productRepository.save(product);
        long size = productRepository.count();

        //Then
        assertEquals(1L, size);

    }

    @Test
    public void shouldGetProduct() {
        //Given
        Product product = productRepository.save(new Product(1L, "Test", "Test", new BigDecimal(2)));

        //When
        Optional<Product> savedProduct = productRepository.findById(product.getId());

        //Then
        assertEquals(product.hashCode(), savedProduct.get().hashCode());
    }

    @Test
    public void shouldUpdateProduct() {
        //Given
        Product product = productRepository.save(new Product(1L, "Test", "Test", new BigDecimal(2)));

        //When
        productRepository.save(new Product(product.getId(), "Test", "TestUpdate", new BigDecimal(2)));
        Optional<Product> updatedProduct = productRepository.findById(product.getId());

        //Then
        assertEquals("TestUpdate", updatedProduct.get().getDescription());
    }

    @Test
    public void testDelete() {
        //Given
        Product product = productRepository.save(new Product(0L, "Test", "Test", new BigDecimal(2)));

        //When
        productRepository.delete(product);
        long size = productRepository.count();

        //Then
        assertEquals(0L, size);
    }

    @Test
    public void testRelationsBetweenProductCartGroup() {
        //Given
        Group group = new Group();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        List<Cart> carts = new ArrayList();
        carts.add(cart1);
        carts.add(cart2);
        groupRepository.save(group);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        Product product = productRepository.save(new Product(0L, "Test", "Test", new BigDecimal(2), carts, group));
        //When
        productRepository.delete(product);
        long sizePR = productRepository.count();
        long sizeGR = groupRepository.count();
        long sizeCR = cartRepository.count();
        //Then
        assertEquals(0L, sizePR);
        assertEquals(1L, sizeGR);
        assertEquals(2L, sizeCR);
    }
}