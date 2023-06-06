package com.eleadmin.RawMaterialManagement.mcustomer.controller;



import com.eleadmin.RawMaterialManagement.mcustomer.service.McustomerService;
import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import com.eleadmin.RawMaterialManagement.mcustomer.param.McustomerParam;

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
 * @since 2023-06-04 21:55:36
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/mcustomer")
public class McustomerController extends BaseController {
    @Resource
    private McustomerService mcustomerService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Mcustomer>> page(McustomerParam param) {
        PageParam<Mcustomer, McustomerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(mcustomerService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(mcustomerService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查找所有客户")
    @GetMapping("/findAllMcustomer")
    public List<Mcustomer> findAllMcustomer(){
        List<Mcustomer> mcustomers =mcustomerService.findAllMcustomer();

        return mcustomerService.findAllMcustomer();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findMcustomerByName/{unitname}")
    public List<Mcustomer> get1(@PathVariable("unitname") String unitname) {
        return mcustomerService.findMcustomerByName(unitname);
    }


    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("增加客户")
    @PutMapping("/addMcustomer")
    public ApiResult<?> addMcustomer(@RequestBody Mcustomer mcustomer){
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(material);
//        System.out.println("2"+material.getContacts());
//        System.out.println("3:"+material.getProcurementtime());

        if (mcustomerService.addMcustomer(mcustomer)){
            return success("新增成功");
        }
        return fail("新增失败");

    }


    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteMcustomer/{id}")
    public void deleteMcustomer(@PathVariable("id") int id){
        System.out.println(id);
        mcustomerService.deleteMcustomer(id);
    }


    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("更新客户")
    @PutMapping("/updateMcustomer")
    public ApiResult<?> updateMcustomer(@RequestBody Mcustomer mcustomer){
        if (mcustomerService.updateMcustomer(mcustomer)){
            System.out.println(mcustomer);
            return success("更新成功");
        }
        return fail("更新失败");

    }


//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:list')")
//    @OperationLog
//    @ApiOperation("查询全部")
//    @GetMapping()
//    public ApiResult<List<Mcustomer>> list(McustomerParam param) {
//        PageParam<Mcustomer, McustomerParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(mcustomerService.list(page.getOrderWrapper()));
//        // 使用关联查询
//        //return success(mcustomerService.listRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:list')")
//    @OperationLog
//    @ApiOperation("根据id查询")
//    @GetMapping("/{id}")
//    public ApiResult<Mcustomer> get(@PathVariable("id") Integer id) {
//        return success(mcustomerService.getById(id));
//        // 使用关联查询
//        //return success(mcustomerService.getByIdRel(id));
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:save')")
//    @OperationLog
//    @ApiOperation("添加")
//    @PostMapping()
//    public ApiResult<?> save(@RequestBody Mcustomer mcustomer) {
//        if (mcustomerService.save(mcustomer)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:update')")
//    @OperationLog
//    @ApiOperation("修改")
//    @PutMapping()
//    public ApiResult<?> update(@RequestBody Mcustomer mcustomer) {
//        if (mcustomerService.updateById(mcustomer)) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:remove')")
//    @OperationLog
//    @ApiOperation("删除")
//    @DeleteMapping("/{id}")
//    public ApiResult<?> remove(@PathVariable("id") Integer id) {
//        if (mcustomerService.removeById(id)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Mcustomer> list) {
//        if (mcustomerService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Mcustomer> batchParam) {
//        if (batchParam.update(mcustomerService, "id")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('mcustomer:mcustomer:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (mcustomerService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
