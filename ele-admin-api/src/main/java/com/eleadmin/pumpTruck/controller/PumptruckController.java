package com.eleadmin.pumpTruck.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.pumpTruck.service.PumptruckService;
import com.eleadmin.pumpTruck.entity.Pumptruck;
import com.eleadmin.pumpTruck.param.PumptruckParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.BatchParam;
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
 * @since 2023-05-13 17:32:14
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/pumpTruck/pumptruck")
public class PumptruckController extends BaseController {
    @Resource
    private PumptruckService pumptruckService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Pumptruck>> page(PumptruckParam param) {
        PageParam<Pumptruck, PumptruckParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(pumptruckService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(pumptruckService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllPumpTrucks")
    public List<Pumptruck> list(PumptruckParam param) {
        return pumptruckService.findAllPumpTrucks();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据pumpTruckNumber查询")
    @GetMapping("/findPumpTrucksBypumpTruckNumber/{pumpTruckNumber}")
    public List<Pumptruck> get(@PathVariable("pumpTruckNumber") String pumpTruckNumber) {
        return pumptruckService.findPumpTrucksBypumpTruckNumber(pumpTruckNumber);
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据pumpTruckid查询")
    @GetMapping("/findPumpTrucksBypumpTruckid/{pumpTruckid}")
    public List<Pumptruck> get2(@PathVariable("pumpTruckid") String pumpTruckid) {
        return pumptruckService.findPumpTrucksBypumpTruckid(pumpTruckid);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addPumpTruck")
    public ApiResult<?> save(@RequestBody Pumptruck pumptruck) {
        if (pumptruckService.addPumpTruck(pumptruck)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updatePumpTruck")
    public ApiResult<?> update(@RequestBody Pumptruck pumptruck) {
        if (pumptruckService.updatePumpTruck(pumptruck)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deletePumpTruck/{id}")
    public void remove(@PathVariable("id") Integer id) {
      pumptruckService.deletePumpTruck(id);
    }
}
