package com.eleadmin.BasicInformationManagement.production.controller;


import com.eleadmin.BasicInformationManagement.production.service.ProductionService;
import com.eleadmin.BasicInformationManagement.production.entity.Production;
import com.eleadmin.BasicInformationManagement.production.param.ProductionParam;

import com.eleadmin.common.core.annotation.OperationLog;
import com.eleadmin.common.core.web.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-05-28 16:40:05
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/production/production")
public class ProductionController extends BaseController {
    @Resource
    private ProductionService productionService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Production>> page(ProductionParam param) {
        PageParam<Production, ProductionParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(productionService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(productionService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllProductions")
    public List<Production> list(ProductionParam param) {
        return productionService.findAllProductions();
    }

    //浇筑方式

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findProductionsByid/{id}")
    public Production get(@PathVariable("id") Integer id) {
        return productionService.findProductionsByid(id);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addProduction")
    public ApiResult<?> save(@RequestBody Production production) {
        if (productionService.addProduction(production)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateProduction")
    public ApiResult<?> update(@RequestBody Production production) {
        if (productionService.updateProduction(production)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteProduction/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (productionService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }


    @PreAuthorize("hasAuthority('production:production:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Production> list) {
        if (productionService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder1")
    public List<Production> list1(ProductionParam param) {
        List<Production> list=productionService.findProductionsToOrder();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==17){
                list1.add(p);
            }
        }
        return list1;
    }
    //强度等级
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder2")
    public List<Production> list2(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==4){
                list1.add(p);
            }
        }
        return list1;
    }
    //坍落度
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder3")
    public List<Production> list3(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==5){
                list1.add(p);
            }
        }
        return list1;
    }
    //抗渗强度
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder4")
    public List<Production> list4(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==6){
                list1.add(p);
            }
        }
        return list1;
    }
    //抗冻等级
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder5")
    public List<Production> list5(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==7){
                list1.add(p);
            }
        }
        return list1;
    }
    //抗硫酸盐强度
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder6")
    public List<Production> list6(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==8){
                list1.add(p);
            }
        }
        return list1;
    }
    //抗氯离子强度
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder7")
    public List<Production> list7(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==9){
                list1.add(p);
            }
        }
        return list1;
    }
    //特殊原材料
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder8")
    public List<Production> list8(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==18){
                list1.add(p);
            }
        }
        return list1;
    }
    //外加剂
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findProductionsToOrder9")
    public List<Production> list9(ProductionParam param) {
        List<Production> list=productionService.findAllProductions();
        List<Production> list1=new ArrayList<>();
        for (Production p:list) {
            if (p.getParentid()==20){
                list1.add(p);
            }
        }
        return list1;
    }
    @PreAuthorize("hasAuthority('production:production:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Production> batchParam) {
        if (batchParam.update(productionService, "propertyId")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('production:production:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (productionService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
