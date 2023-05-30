package com.eleadmin.ConvoyManagement.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.ConvoyManagement.car.entity.Car;
import com.eleadmin.ConvoyManagement.car.param.CarParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-14 15:37:43
 */
public interface CarService extends IService<Car> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Car>
     */
    PageResult<Car> pageRel(CarParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Car>
     */
    List<Car> listRel(CarParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Car
     */
    Car getByIdRel(Integer id);

    List<Car> findAllCars();

    List<Car> findCarByCarNumber(String CarNumber);

    List<Car> findCarBycarIdenNumber(String carIdenNumber);

    List<Car> findCarBypersonInCharge(String personInCharge);


    void deleteCar(int id);

    boolean updateCar(Car car);

    boolean addCar(Car car);


}
