package com.ingker.tmall.entity.controller;

import com.ingker.tmall.entity.pojo.Order;
import com.ingker.tmall.entity.service.impl.OrderItemServiceImpl;
import com.ingker.tmall.entity.service.impl.OrderServiceImpl;
import com.ingker.tmall.util.Page4Navigator;
import com.ingker.tmall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    OrderItemServiceImpl orderItemService;

    @GetMapping("/orders")
    public Page4Navigator<Order> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Order> page =orderService.list(start, size, 5);
        orderItemService.fill(page.getContent());
        orderService.removeOrderFromOrderItem(page.getContent());
        return page;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object deliveryOrder(@PathVariable int oid) throws IOException {
        Order o = orderService.get(oid);
        o.setDeliveryDate(new Date());
        o.setStatus(OrderServiceImpl.waitConfirm);
        orderService.update(o);
        return Result.success();
    }
}

