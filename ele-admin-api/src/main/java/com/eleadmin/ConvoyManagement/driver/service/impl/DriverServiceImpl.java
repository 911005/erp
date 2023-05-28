package com.eleadmin.ConvoyManagement.driver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.ConvoyManagement.driver.mapper.DriverMapper;
import com.eleadmin.ConvoyManagement.driver.service.DriverService;
import com.eleadmin.ConvoyManagement.driver.entity.Driver;
import com.eleadmin.ConvoyManagement.driver.param.DriverParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-13 17:46:30
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements DriverService {
    @Autowired
    private DriverMapper driverMapper;
    @Override
    public PageResult<Driver> pageRel(DriverParam param) {
        PageParam<Driver, DriverParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Driver> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Driver> listRel(DriverParam param) {
        List<Driver> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Driver, DriverParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public List<Driver> findDriversByjobNumber(int number) {
        return driverMapper.findDriversByjobNumber(number);
    }

    @Override
    public List<Driver> findDriversBydriverName(String name) {
        return driverMapper.findDriversBydriverName(name);
    }

    @Override
    public Driver getByIdRel(Integer id) {
        DriverParam param = new DriverParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }


    @Override
    public List<Driver> findAllDrivers() {
        return driverMapper.findAllDrivers();
    }
    @Override
    public void deleteDriver(int id) {
        driverMapper.deleteDriver(id);
    }

    @Override
    public boolean updateDriver(Driver driver) {
        driverMapper.updateDriver(driver);
        System.out.println(driver.getJobnumber());
        return true;
    }

    @Override
    public boolean addDriver(Driver driver) {
        System.out.println(driver.getJobnumber());
        driverMapper.addDriver(driver);
        return true;
    }

}
