package com.ingker.tmall.dao;

import com.ingker.tmall.pojo.Product;
import com.ingker.tmall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer> {

    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);

}