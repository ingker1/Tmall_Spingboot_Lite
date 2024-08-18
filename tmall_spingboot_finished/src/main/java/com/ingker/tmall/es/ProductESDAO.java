package com.ingker.tmall.es;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ingker.tmall.entity.pojo.Product;

public interface ProductESDAO extends ElasticsearchRepository<Product,Integer>{

}