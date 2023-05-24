package com.eleadmin.ConvoyManagement.driver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.ConvoyManagement.driver.entity.Driver;
import com.eleadmin.ConvoyManagement.driver.param.DriverParam;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-13 17:46:30
 */
public interface DriverMapper extends BaseMapper<Driver> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Driver>
     */
    List<Driver> selectPageRel(@Param("page") IPage<Driver> page,
                             @Param("param") DriverParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Driver> selectListRel(@Param("param") DriverParam param);

    /**
     * 查询所有客户信息
     */
    List<Driver> findAllDrivers();
    void updateDriver(Driver driver);
    void addDriver(Driver driver);
    void deleteDriver(int id);
}
