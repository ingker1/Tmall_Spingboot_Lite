package com.ingker.tmall.entity.dao;

import com.ingker.tmall.entity.pojo.Product;
import com.ingker.tmall.entity.pojo.User;
import com.ingker.tmall.entity.pojo.Order;
import com.ingker.tmall.entity.pojo.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
