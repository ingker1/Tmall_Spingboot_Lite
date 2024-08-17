package com.ingker.tmall.service.impl;

import com.ingker.tmall.dao.ReviewDAO;
import com.ingker.tmall.pojo.Product;
import com.ingker.tmall.pojo.Review;
import com.ingker.tmall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDAO reviewDAO;
    @Autowired ProductServiceImpl productService;

    public void add(Review review) {
        reviewDAO.save(review);
    }

    public List<Review> list(Product product){
        List<Review> result =  reviewDAO.findByProductOrderByIdDesc(product);
        return result;
    }

    public int getCount(Product product) {
        return reviewDAO.countByProduct(product);
    }
}
