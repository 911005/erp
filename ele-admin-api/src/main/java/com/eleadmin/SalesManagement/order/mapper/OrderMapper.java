package com.eleadmin.SalesManagement.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.SalesManagement.order.entity.Order;
import com.eleadmin.SalesManagement.order.param.OrderParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-31 15:47:22
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Order>
     */
    List<Order> selectPageRel(@Param("page") IPage<Order> page,
                             @Param("param") OrderParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Order> selectListRel(@Param("param") OrderParam param);

    List<OrderParam> findAllOrders();

    void addOrder(Order order);

//    void addConcrete(Concrete concrete);

    void updateOrder(Order order);

//    void updateConcrete(Concrete concrete);

    void deleteOrder(int id);

}
