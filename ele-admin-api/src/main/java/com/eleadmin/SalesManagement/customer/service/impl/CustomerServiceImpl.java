package com.eleadmin.SalesManagement.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.SalesManagement.customer.mapper.CustomerMapper;
import com.eleadmin.SalesManagement.customer.service.CustomerService;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.SalesManagement.customer.param.CustomerParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-04-26 15:35:14
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAllCustomers() {
        return customerMapper.findAllCustomers();
    }

    @Override
    public void deleteCustomer(int id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
        System.out.println(customer.getUnitname());
        return true;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        System.out.println(customer.getUnitname());
        customerMapper.addCustomer(customer);
        return true;
    }

//    @Override
//    public PageResult<Customer> pageRel(CustomerParam param) {
//        PageParam<Customer, CustomerParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        List<Customer> list = baseMapper.selectPageRel(page, param);
//        return new PageResult<>(list, page.getTotal());
//    }
//
//    @Override
//    public List<Customer> listRel(CustomerParam param) {
//        List<Customer> list = baseMapper.selectListRel(param);
//        // 排序
//        PageParam<Customer, CustomerParam> page = new PageParam<>();
//        //page.setDefaultOrder("create_time desc");
//        return page.sortRecords(list);
//    }
//
//    @Override
//    public Customer getByIdRel(Integer id) {
//        CustomerParam param = new CustomerParam();
//        param.setId(id);
//        return param.getOne(baseMapper.selectListRel(param));
//    }

}
