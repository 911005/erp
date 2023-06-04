package com.eleadmin.RawMaterialManagement.supplier.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.RawMaterialManagement.supplier.service.SupplierService;
import com.eleadmin.RawMaterialManagement.supplier.entity.Supplier;
import com.eleadmin.RawMaterialManagement.supplier.param.SupplierParam;
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
 * @since 2023-06-03 22:38:26
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/supplier/supplier")
public class SupplierController extends BaseController {
    @Resource
    private SupplierService supplierService;

    @PreAuthorize("hasAuthority('supplier:supplier:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Supplier>> page(SupplierParam param) {
        PageParam<Supplier, SupplierParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(supplierService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(supplierService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllSuppliers")
    public List<SupplierParam> list(SupplierParam param) {
        return supplierService.findAllSuppliers();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findByName/{suppliername}")
    public List<SupplierParam> get1(@PathVariable("suppliername") String suppliername) {
        return supplierService.findByName(suppliername);
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findBySaleman/{saleman}")
    public List<SupplierParam> get2(@PathVariable("saleman") String saleman) {
        return supplierService.findBySaleman(saleman);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addSupplier")
    public ApiResult<?> save(@RequestBody Supplier supplier) {
        if (supplierService.addSupplier(supplier)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateSupplier")
    public ApiResult<?> update(@RequestBody Supplier supplier) {
        if (supplierService.updateSupplier(supplier)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteSupplier/{id}")
    public void remove(@PathVariable("id") Integer id) {
            supplierService.deleteSupplier(id);
    }

    @PreAuthorize("hasAuthority('supplier:supplier:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Supplier> list) {
        if (supplierService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('supplier:supplier:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Supplier> batchParam) {
        if (batchParam.update(supplierService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('supplier:supplier:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (supplierService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
