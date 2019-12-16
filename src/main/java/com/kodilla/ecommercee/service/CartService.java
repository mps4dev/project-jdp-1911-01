package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CartService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    public Cart create(CartDto cartDto) {
        return cartRepository.save(cartMapper.mapToCart(cartDto));
    }

    public List<ProductDto> getAll(long cartId) throws EntityNotFoundException {
        List<Product> products = cartRepository.findOrThrow(cartId).getProducts();
        return productMapper.mapToProductDtoList(products);
    }

    public void add(long productId, long cartId) throws EntityNotFoundException {
        Product product = productRepository.findOrThrow(productId);
        cartRepository.findOrThrow(cartId).getProducts().add(product);
    }

    public void remove(long productId, long cartId) throws EntityNotFoundException{
        Product product = productRepository.findOrThrow(productId);
        cartRepository.findOrThrow(cartId).getProducts().remove(product);
    }

    public OrderDto createOrder(CartDto cartDto) {
        Order order = new Order();
        order.setCart(cartMapper.mapToCart(cartDto));
        OrderDto orderDto = orderMapper.mapToOrderDto(order);
        orderService.create(orderDto);
        return orderDto;
    }
}
