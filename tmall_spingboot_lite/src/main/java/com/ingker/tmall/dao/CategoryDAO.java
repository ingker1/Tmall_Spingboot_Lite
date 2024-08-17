package com.ingker.tmall.dao;

import com.ingker.tmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
