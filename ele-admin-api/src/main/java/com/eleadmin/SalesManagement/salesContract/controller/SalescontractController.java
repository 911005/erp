package com.eleadmin.SalesManagement.salesContract.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.SalesManagement.salesContract.service.SalescontractService;
import com.eleadmin.SalesManagement.salesContract.entity.Salescontract;
import com.eleadmin.SalesManagement.salesContract.param.SalescontractParam;
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
 * @since 2023-05-29 17:25:40
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/salesContract/salescontract")
public class SalescontractController extends BaseController {
    @Resource
    private SalescontractService salescontractService;

    @PreAuthorize("hasAuthority('salesContract:salescontract:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Salescontract>> page(SalescontractParam param) {
        PageParam<Salescontract, SalescontractParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(salescontractService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(salescontractService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllSalescontracts")
    public List<SalescontractParam> list(SalescontractParam param) {

        return salescontractService.findAllSalescontracts();
        // 使用关联查询
        //return success(salescontractService.listRel(param));
    }

    @PreAuthorize("hasAuthority('salesContract:salescontract:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Salescontract> get(@PathVariable("id") Integer id) {
        return success(salescontractService.getById(id));
        // 使用关联查询
        //return success(salescontractService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('salesContract:salescontract:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Salescontract salescontract) {
        if (salescontractService.save(salescontract)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateSalescontract")
    public ApiResult<?> update(@RequestBody Salescontract salescontract) {
        if (salescontractService.updateById(salescontract)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('salesContract:salescontract:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (salescontractService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('salesContract:salescontract:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Salescontract> list) {
        if (salescontractService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('salesContract:salescontract:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Salescontract> batchParam) {
        if (batchParam.update(salescontractService, "salesContractId")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('salesContract:salescontract:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (salescontractService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
