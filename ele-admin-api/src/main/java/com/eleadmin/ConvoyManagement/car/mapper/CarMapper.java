package com.eleadmin.ConvoyManagement.car.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.ConvoyManagement.car.entity.Car;
import com.eleadmin.ConvoyManagement.car.param.CarParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-14 15:37:43
 */
public interface CarMapper extends BaseMapper<Car> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Car>
     */
    List<Car> selectPageRel(@Param("page") IPage<Car> page,
                             @Param("param") CarParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Car> selectListRel(@Param("param") CarParam param);

    List<Car> findAllCars();

    List<Car> findCarByCarNumber(String CarNumber);

    List<Car> findCarBycarIdenNumber(String carIdenNumber);

    List<Car> findCarBypersonInCharge(String personInCharge);

    void updateCar(Car car);

    void deleteCar(int id);

    void addCar(Car car);

}
