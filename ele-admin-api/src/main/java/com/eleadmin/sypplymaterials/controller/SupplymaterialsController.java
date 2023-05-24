package com.eleadmin.sypplymaterials.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.sypplymaterials.service.SupplymaterialsService;
import com.eleadmin.sypplymaterials.entity.Supplymaterials;
import com.eleadmin.sypplymaterials.param.SupplymaterialsParam;
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
 * @since 2023-04-26 15:59:35
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/test1/SupplyMaterials")
public class SupplymaterialsController extends BaseController {
    @Resource
    private SupplymaterialsService supplymaterialsService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Supplymaterials>> page(SupplymaterialsParam param) {
        PageParam<Supplymaterials, SupplymaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(supplymaterialsService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(supplymaterialsService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllSupplyM")
    public List<Supplymaterials> list(SupplymaterialsParam param) {
        return supplymaterialsService.findAllSupplyM();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/selectById/{id}")
    public ApiResult<Supplymaterials> get(@PathVariable("id") Integer id) {
        return success(supplymaterialsService.getById(id));
        // 使用关联查询
        //return success(supplymaterialsService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addSupplyM")
    public ApiResult<?> save(@RequestBody Supplymaterials supplymaterials) {
        if (supplymaterialsService.addSupplyM(supplymaterials)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateSupplyM")
    public ApiResult<?> update(@RequestBody Supplymaterials supplymaterials) {
        if (supplymaterialsService.updateSupplyM(supplymaterials)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteSupplyM/{id}")
    public void remove(@PathVariable("id") Integer id) {
        System.out.println(id);
        supplymaterialsService.deleteSupplyM(id);
    }

}
