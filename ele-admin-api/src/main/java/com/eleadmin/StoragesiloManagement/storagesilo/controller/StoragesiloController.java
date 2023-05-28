package com.eleadmin.StoragesiloManagement.storagesilo.controller;

import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.StoragesiloManagement.storagesilo.service.StoragesiloService;
import com.eleadmin.StoragesiloManagement.storagesilo.entity.Storagesilo;
import com.eleadmin.StoragesiloManagement.storagesilo.param.StoragesiloParam;
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
 * @since 2023-05-14 11:24:51
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/storagesilo/storagesilo")
public class StoragesiloController extends BaseController {
    @Resource
    private StoragesiloService storagesiloService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/findAllStoragesilos")
    public List<Storagesilo> findAllStoragesilos(){
        return storagesiloService.findAllStoragesilos();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @DeleteMapping("/deleteStoragesilo/{id}")
    public void deleteStoragesilo(@PathVariable("id") int id){
        System.out.println(id);
        storagesiloService.deleteStoragesilo(id);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/updateStoragesilo")
    public ApiResult<?> updateStoragesilo(@RequestBody Storagesilo storagesilo){
        if (storagesiloService.updateStoragesilo(storagesilo)){
            return success("更新成功");
        }
        return fail("更新失败");

    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/addStoragesilo")
    public ApiResult<?> addStoragesilo(@RequestBody Storagesilo storagesilo){
        System.out.println(storagesilo.getStoragesiloname());
        if (storagesiloService.addStoragesilo(storagesilo)){
            return success("新增成功");
        }
        return fail("新增失败");

    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Storagesilo>> page(StoragesiloParam param) {
        PageParam<Storagesilo, StoragesiloParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(storagesiloService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(storagesiloService.pageRel(param));
    }

//    @PreAuthorize("hasAuthority('storagesilo:storagesilo:list')")
//    @OperationLog
//    @ApiOperation("查询全部")
//    @GetMapping()
//    public ApiResult<List<Storagesilo>> list(StoragesiloParam param) {
//        PageParam<Storagesilo, StoragesiloParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(storagesiloService.list(page.getOrderWrapper()));
//        // 使用关联查询
//        //return success(storagesiloService.listRel(param));
//    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findStoragesilosBystoragesiloName/{storagesiloname}")
    public List<Storagesilo> findStoragesilosBystoragesiloName(@PathVariable("storagesiloname") String storagesiloname) {
        return storagesiloService.findStoragesilosBystoragesiloName(storagesiloname);
    }
    @PreAuthorize("hasAuthority('storagesilo:storagesilo:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findStoragesilosBystorageslioType/{storagesiloType}")
    public List<Storagesilo> findStoragesilosBystorageslioType(@PathVariable("storagesiloType") String storagesilotype) {
        return storagesiloService.findStoragesilosBystorageslioType(storagesilotype);
    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Storagesilo storagesilo) {
        if (storagesiloService.save(storagesilo)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody Storagesilo storagesilo) {
        if (storagesiloService.updateById(storagesilo)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (storagesiloService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Storagesilo> list) {
        if (storagesiloService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Storagesilo> batchParam) {
        if (batchParam.update(storagesiloService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('storagesilo:storagesilo:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (storagesiloService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
