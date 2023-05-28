package com.eleadmin.SalesManagement.customer.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.SalesManagement.customer.service.CustomerService;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.SalesManagement.customer.param.CustomerParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.BatchParam;
import com.eleadmin.common.core.annotation.OperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-04-26 15:35:14
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/customer/customer")
public class CustomerController extends BaseController {
    @Resource
    private CustomerService customerService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/findAllCustomers")
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @PreAuthorize("hasAuthority('customer:customer:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findCustomersByunitName/{unitName}")
    public List<Customer> findCustomersByunitName(@PathVariable("unitName") String name) {
        return customerService.findCustomersByunitName(name);
    }

    @PreAuthorize("hasAuthority('customer:customer:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findCustomersByunitType/{unitType}")
    public List<Customer> findCustomersByunitType(@PathVariable("unitType") String type) {
        return customerService.findCustomersByunitType(type);
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") int id){
        System.out.println(id);
        customerService.deleteCustomer(id);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/updateCustomer")
    public ApiResult<?> updateCustomer(@RequestBody Customer customer){
        if (customerService.updateCustomer(customer)){
            return success("更新成功");
        }
        return fail("更新失败");

    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/addCustomer")
    public ApiResult<?> addCustomer(@RequestBody Customer customer){
        System.out.println(customer.getUnitname());
        if (customerService.addCustomer(customer)){
            return success("新增成功");
        }
        return fail("新增失败");

    }






//    @PreAuthorize("hasAuthority('customer:customer:list')")
//    @OperationLog
//    @ApiOperation("分页查询")
//    @GetMapping("/page")
//    public ApiResult<PageResult<Customer>> page(CustomerParam param) {
//        PageParam<Customer, CustomerParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(customerService.page(page, page.getWrapper()));
//        // 使用关联查询
//        //return success(customerService.pageRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:list')")
//    @OperationLog
//    @ApiOperation("查询全部")
//    @GetMapping()
//    public ApiResult<List<Customer>> list(CustomerParam param) {
//        PageParam<Customer, CustomerParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        return success(customerService.list(page.getOrderWrapper()));
//        // 使用关联查询
//        //return success(customerService.listRel(param));
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:list')")
//    @OperationLog
//    @ApiOperation("根据id查询")
//    @GetMapping("/{id}")
//    public ApiResult<Customer> get(@PathVariable("id") Integer id) {
//        return success(customerService.getById(id));
//        // 使用关联查询
//        //return success(customerService.getByIdRel(id));
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:save')")
//    @OperationLog
//    @ApiOperation("添加")
//    @PostMapping()
//    public ApiResult<?> save(@RequestBody Customer customer) {
//        if (customerService.save(customer)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:update')")
//    @OperationLog
//    @ApiOperation("修改")
//    @PutMapping()
//    public ApiResult<?> update(@RequestBody Customer customer) {
//        if (customerService.updateById(customer)) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:remove')")
//    @OperationLog
//    @ApiOperation("删除")
//    @DeleteMapping("/{id}")
//    public ApiResult<?> remove(@PathVariable("id") Integer id) {
//        if (customerService.removeById(id)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Customer> list) {
//        if (customerService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Customer> batchParam) {
//        if (batchParam.update(customerService, "id")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('customer:customer:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (customerService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
