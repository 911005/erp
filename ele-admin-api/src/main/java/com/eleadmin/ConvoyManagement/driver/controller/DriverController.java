package com.eleadmin.ConvoyManagement.driver.controller;

import com.eleadmin.ConvoyManagement.driver.service.DriverService;
import com.eleadmin.ConvoyManagement.driver.entity.Driver;
import com.eleadmin.ConvoyManagement.driver.param.DriverParam;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.common.core.annotation.OperationLog;
import com.eleadmin.common.core.web.*;
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
 * @since 2023-05-13 17:46:30
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/driver/driver")
public class DriverController extends BaseController {
    @Resource
    private DriverService driverService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/findAllDrivers")
    public List<Driver> findAllDrivers(){
        return driverService.findAllDrivers();
    }


    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/updateDriver")
    public ApiResult<?> updateDriver(@RequestBody Driver driver){
        if (driverService.updateDriver(driver)){
            return success("更新成功");
        }
        return fail("更新失败");

    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/addDriver")
    public ApiResult<?> addDriver(@RequestBody Driver driver){
        System.out.println(driver.getJobnumber());
        if (driverService.addDriver(driver)){
            return success("新增成功");
        }
        return fail("新增失败");

    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @DeleteMapping("/deleteDriver/{id}")
    public void deleteDriver(@PathVariable("id") int id){
        System.out.println(id);
        driverService.deleteDriver(id);
    }

//    @PreAuthorize("hasAuthority('driver:driver:list')")
//    @OperationLog
//    @ApiOperation("分页查询")
//    @GetMapping("/page")
//    public ApiResult<PageResult<Driver>> page(DriverParam param) {
//        PageParam<Driver, DriverParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(driverService.page(page, page.getWrapper()));
//        // 使用关联查询
//        //return success(driverService.pageRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:list')")
//    @OperationLog
//    @ApiOperation("查询全部")
//    @GetMapping()
//    public ApiResult<List<Driver>> list(DriverParam param) {
//        PageParam<Driver, DriverParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(driverService.list(page.getOrderWrapper()));
//        // 使用关联查询
//        //return success(driverService.listRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:list')")
//    @OperationLog
//    @ApiOperation("根据id查询")
//    @GetMapping("/{id}")
//    public ApiResult<Driver> get(@PathVariable("id") Integer id) {
//        return success(driverService.getById(id));
//        // 使用关联查询
//        //return success(driverService.getByIdRel(id));
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:save')")
//    @OperationLog
//    @ApiOperation("添加")
//    @PostMapping()
//    public ApiResult<?> save(@RequestBody Driver driver) {
//        if (driverService.save(driver)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:update')")
//    @OperationLog
//    @ApiOperation("修改")
//    @PutMapping()
//    public ApiResult<?> update(@RequestBody Driver driver) {
//        if (driverService.updateById(driver)) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:remove')")
//    @OperationLog
//    @ApiOperation("删除")
//    @DeleteMapping("/{id}")
//    public ApiResult<?> remove(@PathVariable("id") Integer id) {
//        if (driverService.removeById(id)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Driver> list) {
//        if (driverService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Driver> batchParam) {
//        if (batchParam.update(driverService, "id")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('driver:driver:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (driverService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
