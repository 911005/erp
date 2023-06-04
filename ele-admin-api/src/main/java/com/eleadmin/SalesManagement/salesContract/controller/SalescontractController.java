package com.eleadmin.SalesManagement.salesContract.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.SalesManagement.salesContract.service.SalescontractService;
import com.eleadmin.SalesManagement.salesContract.entity.Salescontract;
import com.eleadmin.SalesManagement.salesContract.param.SalescontractParam;
import com.eleadmin.common.core.web.ApiResult;
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


    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllSalescontracts")
    public List<SalescontractParam> findAllSalescontracts(SalescontractParam param) {
        System.out.println(salescontractService.findAllSalescontracts());
        return salescontractService.findAllSalescontracts();
        // 使用关联查询
        //return success(salescontractService.listRel(param));
    }
    //根据客户名称查找工程
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据客户名称查询")
    @GetMapping("/findSalescontractsByNumber/{number}")
    public List<SalescontractParam> findSalescontractsByNumber(@PathVariable("number") String number) {
        return salescontractService.findSalescontractsByNumber(number);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addSalescontract")
    public ApiResult<?> addSalescontract(@RequestBody Salescontract salescontract) {
       System.out.println(salescontract.getSalescontractid());
        if (salescontractService.save(salescontract)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateSalescontract")
    public ApiResult<?> updateSalescontract(@RequestBody Salescontract salescontract) {
        if (salescontractService.updateSalescontract(salescontract)) {
            return success("修改成功");
        }
        System.out.println(salescontractService.updateSalescontract(salescontract));
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteSalescontract/{salescontractId}")
    public void deleteSalescontract(@PathVariable("salescontractId") int salescontractId){
        System.out.println(salescontractId);
        salescontractService.deleteSalescontract(salescontractId);
    }


}
