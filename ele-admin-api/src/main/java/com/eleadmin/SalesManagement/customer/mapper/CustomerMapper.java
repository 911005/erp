package com.eleadmin.SalesManagement.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.SalesManagement.customer.param.CustomerParam;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-04-26 15:35:14
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 查询所有客户信息
     */
    List<Customer> findAllCustomers();

    List<Customer> findCustomersByunitName(String name);

    List<Customer> findCustomersByunitType(String type);
    /**
     * 删除客户信息
     * @param id
     */
    void deleteCustomer(int id);

    /**
     * 更新客户信息
     * @param customer
     */
    void updateCustomer(Customer customer);

    void addCustomer(Customer customer);


//    /**
//     * 分页查询
//     *
//     * @param page  分页对象
//     * @param param 查询参数
//     * @return List<Customer>
//     */
//    List<Customer> selectPageRel(@Param("page") IPage<Customer> page,
//                             @Param("param") CustomerParam param);
//
//    /**
//     * 查询全部
//     *
//     * @param param 查询参数
//     * @return List<User>
//     */
//    List<Customer> selectListRel(@Param("param") CustomerParam param);

}
