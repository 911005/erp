package com.eleadmin.SalesManagement.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.SalesManagement.order.mapper.OrderMapper;
import com.eleadmin.SalesManagement.order.service.OrderService;
import com.eleadmin.SalesManagement.order.entity.Order;
import com.eleadmin.SalesManagement.order.param.OrderParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-31 15:47:22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageResult<Order> pageRel(OrderParam param) {
        PageParam<Order, OrderParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Order> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Order> listRel(OrderParam param) {
        List<Order> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Order, OrderParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Order getByIdRel(Integer id) {
        OrderParam param = new OrderParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<OrderParam> findAllOrders() {
        return orderMapper.findAllOrders();
    }

    @Override
    public boolean addOrder(Order order) {
        System.out.println(order.getOrdernumber());
//        System.out.println(concrete.getConcretemarkings());
//        orderMapper.addConcrete(concrete);
        orderMapper.addOrder(order);
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        orderMapper.updateOrder(order);
//        orderMapper.updateConcrete(concrete);
        System.out.println(order.getOrdernumber());
//        System.out.println(concrete.getConcretemarkings());
        return true;
    }

    @Override
    public void deleteOrder(int id) {
        orderMapper.deleteOrder(id);
    }

}
