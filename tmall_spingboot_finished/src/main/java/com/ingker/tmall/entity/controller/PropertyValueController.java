package com.ingker.tmall.entity.controller;
import java.util.List;

import com.ingker.tmall.entity.pojo.Product;
import com.ingker.tmall.entity.pojo.PropertyValue;
import com.ingker.tmall.entity.service.impl.PropertyValueServiceImpl;
import com.ingker.tmall.entity.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueServiceImpl propertyValueService;
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception {
        Product product = productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues = propertyValueService.list(product);
        return propertyValues;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception {
        propertyValueService.update(bean);
        return bean;
    }

}

