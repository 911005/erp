package com.eleadmin.ConvoyManagement.tanker.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.ConvoyManagement.tanker.service.TankerService;
import com.eleadmin.ConvoyManagement.tanker.entity.Tanker;
import com.eleadmin.ConvoyManagement.tanker.param.TankerParam;
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
 * @since 2023-05-13 15:42:42
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/test1/tanker")
public class TankerController extends BaseController {

    @Resource
    private TankerService tankerService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Tanker>> page(TankerParam param) {
        PageParam<Tanker, TankerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(tankerService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(tankerService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllTankers")
    public List<Tanker> list(TankerParam param) {
        return tankerService.findAllTankers();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findTankersBytankCarId/{id}")
    public List<Tanker> get(@PathVariable("id") String id) {
        return tankerService.findTankersBytankCarId(id);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findTankersBytankCarNumber/{tankCarnumber}")
    public List<Tanker> get1(@PathVariable("tankCarnumber") String tankCarnumber) {
        return tankerService.findTankersBytankCarNumber(tankCarnumber);
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addTanker")
    public ApiResult<?> save(@RequestBody Tanker tanker) {
        if (tankerService.addTanker(tanker)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateTanker")
    public ApiResult<?> update(@RequestBody Tanker tanker) {
        if (tankerService.updateTanker(tanker)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteTanker/{id}")
    public void remove(@PathVariable("id") Integer id) {
        tankerService.deleteTanker(id);
    }

}
