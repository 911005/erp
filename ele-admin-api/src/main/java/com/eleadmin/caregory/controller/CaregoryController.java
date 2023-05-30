package com.eleadmin.caregory.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.caregory.service.CaregoryService;
import com.eleadmin.caregory.entity.Caregory;
import com.eleadmin.caregory.param.CaregoryParam;
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
 * @since 2023-05-28 18:23:59
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/caregory/caregory")
public class CaregoryController extends BaseController {
    @Resource
    private CaregoryService caregoryService;

    @PreAuthorize("hasAuthority('caregory:caregory:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Caregory>> page(CaregoryParam param) {
        PageParam<Caregory, CaregoryParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(caregoryService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(caregoryService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllCaregorys")
    public List<Caregory> list(Caregory param) {
       return caregoryService.findAllCaregorys();
    }

    @PreAuthorize("hasAuthority('caregory:caregory:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Caregory> get(@PathVariable("id") Integer id) {
        return success(caregoryService.getById(id));
        // 使用关联查询
        //return success(caregoryService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addCaregory")
    public ApiResult<?> save(@RequestBody Caregory caregory) {
        if (caregoryService.addCaregory(caregory)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateCaregory")
    public ApiResult<?> update(@RequestBody Caregory caregory) {
        if (caregoryService.updateCaregory(caregory)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteCaregory/{subcaregory}")
    public void remove(@PathVariable("subcaregory") String subcaregory) {
        caregoryService.deleteCaregory(subcaregory);
    }

//    @PreAuthorize("hasAuthority('caregory:caregory:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Caregory> list) {
//        if (caregoryService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('caregory:caregory:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Caregory> batchParam) {
//        if (batchParam.update(caregoryService, "id")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('caregory:caregory:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (caregoryService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
