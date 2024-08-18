package com.ingker.tmall.entity.dao;

import com.ingker.tmall.entity.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
