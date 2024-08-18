package com.ingker.tmall.entity.service.impl;

import com.ingker.tmall.entity.dao.PropertyDAO;
import com.ingker.tmall.entity.pojo.Property;
import com.ingker.tmall.entity.pojo.Category;
import com.ingker.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames="properties")
public class PropertyServiceImpl {
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired CategoryServiceImpl categoryService;

    @CacheEvict(allEntries=true)
    public void add(Property bean) {
        propertyDAO.save(bean);
    }

    @CacheEvict(allEntries=true)
    public void delete(int id) {
        propertyDAO.delete(id);
    }

    @Cacheable(key="'properties-one-'+ #p0")
    public Property get(int id) {
        return propertyDAO.findOne(id);
    }

    @CacheEvict(allEntries=true)
    public void update(Property bean) {
        propertyDAO.save(bean);
    }

    @Cacheable(key="'properties-cid-'+#p0+'-page-'+#p1 + '-' + #p2 ")
    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);

        Page<Property> pageFromJPA =propertyDAO.findByCategory(category,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);

    }

    @Cacheable(key="'properties-cid-'+ #p0.id")
    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }
}
