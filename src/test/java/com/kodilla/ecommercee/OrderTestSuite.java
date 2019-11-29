package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(MockitoJUnitRunner.class)
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    private List<Order> orders;

    @Before
    public void setup() {
        orders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Order order = new Order();
            orderRepository.save(order);
            orders.add(order);
        }
    }

    @After
    public void deleteData() {
        orderRepository.deleteAll();
    }

    @Test
    public void deleteProductTest() throws OrderNotFoundException {
        //Given
        Order order = orderRepository.findById(1L).orElseThrow(OrderNotFoundException::new);

        //When

        //Then
        Assert.assertEquals(2, orders.size());
    }

    @Test
    public void addOrdertTest() throws OrderNotFoundException {
        //Given
        Order order = new Order();

        //When
        orderRepository.save(order);
        orders.add(order);

        //Then
        Assert.assertEquals(3, orders.size());
    }
}
