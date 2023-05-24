package com.eleadmin.ConvoyManagement.driver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.ConvoyManagement.driver.entity.Driver;
import com.eleadmin.ConvoyManagement.driver.param.DriverParam;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-13 17:46:30
 */
public interface DriverService extends IService<Driver> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Driver>
     */
    PageResult<Driver> pageRel(DriverParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Driver>
     */
    List<Driver> listRel(DriverParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Driver
     */
    Driver getByIdRel(Integer id);



    /**
     * 查询
     * @return
     */
    List<Driver> findAllDrivers();
    boolean updateDriver(Driver driver);
    void deleteDriver(int id);
    boolean addDriver(Driver driver);
}
