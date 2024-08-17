package com.ingker.tmall.dao;

import com.ingker.tmall.pojo.Order;
import com.ingker.tmall.pojo.OrderItem;
import com.ingker.tmall.pojo.Product;
import com.ingker.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
