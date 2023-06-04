package com.eleadmin.ConvoyManagement.car.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.ConvoyManagement.car.service.CarService;
import com.eleadmin.ConvoyManagement.car.entity.Car;
import com.eleadmin.ConvoyManagement.car.param.CarParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.annotation.OperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-05-14 15:37:43
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/car/car")
public class CarController extends BaseController {
    @Resource
    private CarService carService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Car>> page(CarParam param) {
        PageParam<Car, CarParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(carService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(carService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllCars")
    public List<Car> list(Car param) {
        return carService.findAllCars();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据CarNumber查询")
    @GetMapping("/selectByCarNumber/{CarNumber}")
    public List<Car> get(@PathVariable("CarNumber") String CarNumber) {
       return  carService.findCarByCarNumber(CarNumber);
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据carIdenNumber查询")
    @GetMapping("/selectBycarid/{carid}")
    public List<Car> getBycarIdenNumber(@PathVariable("carid") String carid) {
        return  carService.findCarBycarId(carid);
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据personInCharge查询")
    @GetMapping("/selectBypersonInCharge/{personInCharge}")
    public List<Car> getBypersonInCharge(@PathVariable("personInCharge") String personInCharge) {
        return  carService.findCarBypersonInCharge(personInCharge);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addCar")
    public ApiResult<?> save(@RequestBody Car car) {
        if (carService.addCar(car)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateCar")
    public ApiResult<?> update(@RequestBody Car car) {
        if (carService.updateCar(car)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteCar/{id}")
    public void remove(@PathVariable("id") Integer id) {
        System.out.println(id);
        carService.deleteCar(id);
    }
}
