package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public Cart mapToCart(final CartDto cartDto) {
        if (cartDto == null) return null;
        return new Cart();
    }

    public CartDto mapToCartDto(final Cart cart) {
        if (cart == null) return null;
        return new CartDto();
    }

    public List<Cart> mapToCartList(final List<CartDto> dtoCarts) {
        if (dtoCarts == null) return null;
        return dtoCarts.stream()
                .map(c -> mapToCart(c))
                .collect(Collectors.toList());
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        if (carts == null) return null;
        return carts.stream()
                .map(c -> mapToCartDto(c))
                .collect(Collectors.toList());
    }
}
