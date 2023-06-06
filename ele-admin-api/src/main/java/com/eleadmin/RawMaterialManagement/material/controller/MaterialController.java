package com.eleadmin.RawMaterialManagement.material.controller;

import cn.hutool.core.date.DateTime;
import com.eleadmin.RawMaterialManagement.material.service.MaterialService;
import com.eleadmin.RawMaterialManagement.material.entity.Material;
import com.eleadmin.RawMaterialManagement.material.param.MaterialParam;

import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import com.eleadmin.common.core.annotation.OperationLog;
import com.eleadmin.common.core.web.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-05-31 09:31:17
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/material")
public class MaterialController extends BaseController {
    @Resource
    private MaterialService materialService;

    @PreAuthorize("hasAuthority('material:material:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Material>> page(MaterialParam param) {
        PageParam<Material, MaterialParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(materialService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(materialService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据时间查询")
    @GetMapping("/findMAByPtime{procurementTime}")
    public List<Material> findMAByPtime(@PathVariable("procurementTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") DateTime datetime) {
//        @RequestParam("datetime")
        return materialService.findMAByPtime(datetime);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据供应商查询")
    @GetMapping("/findMABysupplier{correspondenceUnit}")
    public List<Material> findMABysupplier(@PathVariable("correspondenceUnit") String supplier) {
        return materialService.findMABysupplier(supplier);
    }


    @PreAuthorize("hasAuthority('material:material:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<Material>> list(MaterialParam param) {
        PageParam<Material, MaterialParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(materialService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(materialService.listRel(param));
    }
//    @PreAuthorize("hasAuthority('material:material:list')")
    @OperationLog
    @ApiOperation("根据协议查找")
    @GetMapping("/findAllMA")
    public List<Material> findAllMA(){
       List<Material> materials=materialService.findAllMA();
        List<String> materialNames = new ArrayList<>();
        for (Material material : materials) {
            materialNames.add(material.getPurchaseagreementnum());
        }
        System.out.println("查询结果：" + materialNames);
        return materialService.findAllMA();
    }

    @OperationLog
    @ApiOperation("删除协议")
    @DeleteMapping("/deleteMaterial/{id}")
    public void deleteMaterial(@PathVariable("id") int id){
//        int id2 = Integer.parseInt(id);
        System.out.println(id);
        materialService.deleteMaterial(id);
    }

    @OperationLog
    @ApiOperation("更新工程")
    @PutMapping("/updateMaterial")
    public ApiResult<?> updateMaterial(@RequestBody Material material){
        if (materialService.updateMaterial(material)){
            System.out.println(material);
            return success("更新成功");
        }
        return fail("更新失败");

    }

//    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加工程")
    @PutMapping("/addMaterial")
    public ApiResult<?> addMaterial(@RequestBody Material material){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(material);
        System.out.println("2"+material.getContacts());
        System.out.println("3:"+material.getProcurementtime());

        if (materialService.addMaterial(material)){
            return success("新增成功");
        }
        return fail("新增失败");

    }

    @PreAuthorize("hasAuthority('material:material:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Material> get(@PathVariable("id") Integer id) {
        return success(materialService.getById(id));
        // 使用关联查询
        //return success(materialService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('material:material:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Material material) {
        if (materialService.save(material)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }


    @PreAuthorize("hasAuthority('material:material:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody Material material) {
        if (materialService.updateById(material)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('material:material:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (materialService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('material:material:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Material> list) {
        if (materialService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('material:material:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Material> batchParam) {
        if (batchParam.update(materialService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('material:material:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (materialService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
