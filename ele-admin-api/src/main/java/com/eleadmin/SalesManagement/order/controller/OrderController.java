package com.eleadmin.SalesManagement.order.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.SalesManagement.order.service.OrderService;
import com.eleadmin.SalesManagement.order.entity.Order;
import com.eleadmin.SalesManagement.order.param.OrderParam;
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
 * @since 2023-05-31 15:47:22
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/order/order")
public class OrderController extends BaseController {
    @Resource
    private OrderService orderService;

    @PreAuthorize("hasAuthority('order:order:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Order>> page(OrderParam param) {
        PageParam<Order, OrderParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(orderService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(orderService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllOrders")
    public List<OrderParam> list(OrderParam param) {
        System.out.println(orderService.findAllOrders());
        return orderService.findAllOrders();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Order> get(@PathVariable("id") Integer id) {
        return success(orderService.getById(id));
        // 使用关联查询
        //return success(orderService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addOrder")
    public ApiResult<?> save(@RequestBody Order order) {
        if (orderService.addOrder(order)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateOrder")
    public ApiResult<?> update(@RequestBody Order order) {
        if (orderService.updateOrder(order)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteOrder/{id}")
    public void remove(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);
    }

    @PreAuthorize("hasAuthority('order:order:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Order> list) {
        if (orderService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('order:order:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Order> batchParam) {
        if (batchParam.update(orderService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('order:order:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (orderService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
