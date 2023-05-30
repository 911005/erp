package com.eleadmin.ConvoyManagement.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.ConvoyManagement.car.mapper.CarMapper;
import com.eleadmin.ConvoyManagement.car.service.CarService;
import com.eleadmin.ConvoyManagement.car.entity.Car;
import com.eleadmin.ConvoyManagement.car.param.CarParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-14 15:37:43
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    @Autowired
    CarMapper carMapper;

    @Override
    public PageResult<Car> pageRel(CarParam param) {
        PageParam<Car, CarParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Car> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Car> listRel(CarParam param) {
        List<Car> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Car, CarParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Car getByIdRel(Integer id) {
        CarParam param = new CarParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Car> findAllCars() {
        return carMapper.findAllCars();
    }

    @Override
    public List<Car> findCarByCarNumber(String CarNumber) {
        return carMapper.findCarByCarNumber(CarNumber);
    }

    @Override
    public List<Car> findCarBycarIdenNumber(String carIdenNumber) {
        return carMapper.findCarBycarIdenNumber(carIdenNumber);
    }

    @Override
    public List<Car> findCarBypersonInCharge(String personInCharge) {
        return carMapper.findCarBypersonInCharge(personInCharge);
    }

    @Override
    public void deleteCar(int id) {
        carMapper.deleteCar(id);
    }

    @Override
    public boolean updateCar(Car car) {
        carMapper.updateCar(car);
        System.out.println(car.getCarid());
        return true;
    }

    @Override
    public boolean addCar(Car car) {
        System.out.println(car.getCarid());
        carMapper.addCar(car);
        return true;
    }

}
