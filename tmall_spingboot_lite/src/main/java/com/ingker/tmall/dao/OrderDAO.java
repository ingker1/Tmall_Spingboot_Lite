package com.ingker.tmall.dao;

import com.ingker.tmall.pojo.Order;
import com.ingker.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order,Integer> {
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
