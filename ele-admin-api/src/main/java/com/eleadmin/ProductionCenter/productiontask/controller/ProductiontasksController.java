package com.eleadmin.ProductionCenter.productiontask.controller;

import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.ProductionCenter.productiontask.service.ProductiontasksService;
import com.eleadmin.ProductionCenter.productiontask.entity.Productiontasks;
import com.eleadmin.ProductionCenter.productiontask.param.ProductiontasksParam;
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
 * @since 2023-06-03 15:41:21
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/productiontask/productiontasks")
public class ProductiontasksController extends BaseController {
    @Resource
    private ProductiontasksService productiontasksService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询")
    @GetMapping("/findAllProductiontasks")
    public List<ProductiontasksParam> findAllProductiontasks(){

        return productiontasksService.findAllProductiontasks();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据编号查询")
    @GetMapping("/findProductionTasksByMnumber/{mnumber}")
    public List<ProductiontasksParam> findProductionTasksByMnumber(@PathVariable("mnumber") String mnumber){

        return productiontasksService.findProductionTasksByMnumber(mnumber);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteProductiontasks/{id}")
    public void deleteProductiontasks(@PathVariable("id") int id){
        System.out.println(id);
        productiontasksService.deleteProductiontasks(id);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("更新")
    @PutMapping("/updateProductiontasks")
    public ApiResult<?> updateProductiontasks(@RequestBody Productiontasks productiontasks){
        if (productiontasksService.updateProductiontasks(productiontasks)){
            return success("更新成功");
        }
        return fail("更新失败");

    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("新增")
    @PutMapping("/addProductiontasks")
    public ApiResult<?> addProductiontasks(@RequestBody Productiontasks productiontasks){
        System.out.println(productiontasks.getMissonid());
        if (productiontasksService.addProductiontasks(productiontasks)){
            return success("新增成功");
        }
        return fail("新增失败");

    }


//    @PreAuthorize("hasAuthority('productiontask:productiontasks:list')")
//    @OperationLog
//    @ApiOperation("分页查询")
//    @GetMapping("/page")
//    public ApiResult<PageResult<Productiontasks>> page(ProductiontasksParam param) {
//        PageParam<Productiontasks, ProductiontasksParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(productiontasksService.page(page, page.getWrapper()));
//        // 使用关联查询
//        //return success(productiontasksService.pageRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:list')")
//    @OperationLog
//    @ApiOperation("查询全部")
//    @GetMapping()
//    public ApiResult<List<Productiontasks>> list(ProductiontasksParam param) {
//        PageParam<Productiontasks, ProductiontasksParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(productiontasksService.list(page.getOrderWrapper()));
//        // 使用关联查询
//        //return success(productiontasksService.listRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:list')")
//    @OperationLog
//    @ApiOperation("根据id查询")
//    @GetMapping("/{id}")
//    public ApiResult<Productiontasks> get(@PathVariable("id") Integer id) {
//        return success(productiontasksService.getById(id));
//        // 使用关联查询
//        //return success(productiontasksService.getByIdRel(id));
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:save')")
//    @OperationLog
//    @ApiOperation("添加")
//    @PostMapping()
//    public ApiResult<?> save(@RequestBody Productiontasks productiontasks) {
//        if (productiontasksService.save(productiontasks)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:update')")
//    @OperationLog
//    @ApiOperation("修改")
//    @PutMapping()
//    public ApiResult<?> update(@RequestBody Productiontasks productiontasks) {
//        if (productiontasksService.updateById(productiontasks)) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:remove')")
//    @OperationLog
//    @ApiOperation("删除")
//    @DeleteMapping("/{id}")
//    public ApiResult<?> remove(@PathVariable("id") Integer id) {
//        if (productiontasksService.removeById(id)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Productiontasks> list) {
//        if (productiontasksService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Productiontasks> batchParam) {
//        if (batchParam.update(productiontasksService, "missonId")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('productiontask:productiontasks:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (productiontasksService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
