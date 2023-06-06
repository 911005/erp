package com.eleadmin.RawMaterialManagement.concreteuser.controller;
import com.eleadmin.RawMaterialManagement.concreteuser.service.ConcreteuserService;
import com.eleadmin.RawMaterialManagement.concreteuser.entity.Concreteuser;
import com.eleadmin.RawMaterialManagement.concreteuser.param.ConcreteuserParam;
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
 * @since 2023-06-05 11:45:54
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/concreteuser")
public class ConcreteuserController extends BaseController {
    @Resource
    private ConcreteuserService concreteuserService;


    @OperationLog
    @ApiOperation("查找所有客户")
    @GetMapping("/findAllConcreteuser")
    public List<Concreteuser> findAllConcreteuser(){
        List<Concreteuser> concreteusers =concreteuserService.findAllConcreteuser();

        return concreteuserService.findAllConcreteuser();
    }


    //    @PreAuthorize("hasAuthority('mcustomer:mcustomer:list')")
    @OperationLog
    @ApiOperation("增加客户")
    @PutMapping("/addConcreteuser")
    public ApiResult<?> addConcreteuser(@RequestBody Concreteuser concreteuser){
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(material);
//        System.out.println("2"+material.getContacts());
//        System.out.println("3:"+material.getProcurementtime());

        if (concreteuserService.addConcreteuser(concreteuser)){
            return success("新增成功");
        }
        return fail("新增失败");

    }


    @OperationLog
    @ApiOperation("删除协议")
    @DeleteMapping("/deleteConcreteuser/{id}")
    public void deleteConcreteuser(@PathVariable("id") int id){
        System.out.println(id);
        concreteuserService.deleteConcreteuser(id);
    }



    @OperationLog
    @ApiOperation("更新客户")
    @PutMapping("/updateConcreteuser")
    public ApiResult<?> updateConcreteuser(@RequestBody Concreteuser concreteuser){
        if (concreteuserService.updateConcreteuser(concreteuser)){
            System.out.println(concreteuser);
            return success("更新成功");
        }
        return fail("更新失败");

    }







    @PreAuthorize("hasAuthority('concreteuser:concreteuser:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Concreteuser>> page(ConcreteuserParam param) {
        PageParam<Concreteuser, ConcreteuserParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(concreteuserService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(concreteuserService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<Concreteuser>> list(ConcreteuserParam param) {
        PageParam<Concreteuser, ConcreteuserParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(concreteuserService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(concreteuserService.listRel(param));
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Concreteuser> get(@PathVariable("id") Integer id) {
        return success(concreteuserService.getById(id));
        // 使用关联查询
        //return success(concreteuserService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Concreteuser concreteuser) {
        if (concreteuserService.save(concreteuser)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody Concreteuser concreteuser) {
        if (concreteuserService.updateById(concreteuser)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (concreteuserService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Concreteuser> list) {
        if (concreteuserService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Concreteuser> batchParam) {
        if (batchParam.update(concreteuserService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('concreteuser:concreteuser:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (concreteuserService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
