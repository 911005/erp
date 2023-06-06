package com.eleadmin.SalesManagement.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.SalesManagement.order.entity.Order;
import com.eleadmin.SalesManagement.order.param.OrderParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-31 15:47:22
 */
public interface OrderService extends IService<Order> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Order>
     */
    PageResult<Order> pageRel(OrderParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Order>
     */
    List<Order> listRel(OrderParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Order
     */
    Order getByIdRel(Integer id);

    List<OrderParam> findAllOrders();

    List<OrderParam> findOrdersByNumber(String ordernumber);


    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    void deleteOrder(int id);

}
