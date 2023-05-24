package com.eleadmin.SalesManagement.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.SalesManagement.customer.entity.Customer;


import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-04-26 15:35:14
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 查询
     * @return
     */
    List<Customer> findAllCustomers();

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCustomer(int id);

    /**
     * 更新
     */
    boolean updateCustomer(Customer customer);

    boolean addCustomer(Customer customer);




//    /**
//     * 分页关联查询
//     *
//     * @param param 查询参数
//     * @return PageResult<Customer>
//     */
//    PageResult<Customer> pageRel(CustomerParam param);
//
//    /**
//     * 关联查询全部
//     *
//     * @param param 查询参数
//     * @return List<Customer>
//     */
//    List<Customer> listRel(CustomerParam param);
//
//    /**
//     * 根据id查询
//     *
//     * @param id
//     * @return Customer
//     */
//    Customer getByIdRel(Integer id);

}
