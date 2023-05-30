package com.eleadmin.BasicInformationManagement.materials.controller;

import com.eleadmin.BasicInformationManagement.materials.entity.Materials;
import com.eleadmin.BasicInformationManagement.materials.param.MaterialsParam;
import com.eleadmin.BasicInformationManagement.materials.service.MaterialsService;
import com.eleadmin.common.core.web.BaseController;

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
 * @since 2023-05-29 16:16:43
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/materials/materials")
public class MaterialsController extends BaseController {
    @Resource
    private MaterialsService materialsService;

    @PreAuthorize("hasAuthority('materials:materials:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Materials>> page(MaterialsParam param) {
        PageParam<Materials, MaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(materialsService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(materialsService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findmaterials")
    public List<Materials> list(Materials param) {
        return materialsService.findmaterials();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findmaterialsByCaregory/{caregoryid}")
    public List<Materials> get(@PathVariable("caregoryid") int caregoryid) {
        return materialsService.findmaterialsByCaregory(caregoryid);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addmaterials")
    public ApiResult<?> save(@RequestBody Materials materials) {
        if (materialsService.addmaterials(materials)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateMaterials")
    public ApiResult<?> update(@RequestBody Materials materials) {
        if (materialsService.updateMaterials(materials)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleltematerials/{rawname}")
    public void remove(@PathVariable("rawname") String rawname) {
        materialsService.deleltematerials(rawname);
    }

//    @PreAuthorize("hasAuthority('materials:materials:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Materials> list) {
//        if (materialsService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('materials:materials:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Materials> batchParam) {
//        if (batchParam.update(materialsService, "id")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('materials:materials:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (materialsService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
