package com.eleadmin.SalesManagement.project.controller;



import com.eleadmin.SalesManagement.project.entity.Project;
import com.eleadmin.SalesManagement.project.service.ProjectService;
import com.eleadmin.common.core.annotation.OperationLog;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.BaseController;
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
 * @since 2023-05-17 16:03:03
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/project")
public class ProjectController extends BaseController {
    @Resource
    private ProjectService projectService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询工程")
    @GetMapping("/findAllProject")
        public List<Project> findAllProject(){
            return projectService.findAllProject();
        }

    //根据客户名称查找工程
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据客户名称查询")
    @GetMapping("/findProjectsBycustomerName/{customerName}")
    public List<Project> findProjectsBycustomerName(@PathVariable("customerName") String name) {
        return projectService.findProjectsBycustomerName(name);
    }
    //根据工程名称查找工程
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("根据工程名称查询")
    @GetMapping("/findProjectsByprojectName/{projectName}")
    public List<Project> findProjectsByprojectName(@PathVariable("projectName") String pname) {
        return projectService.findProjectsByprojectName(pname);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("删除工程")
    @DeleteMapping("/deleteProject/{projectId}")
    public void deleteCustomer(@PathVariable("projectId") int projectId){
        System.out.println(projectId);
        projectService.deleteProject(projectId);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("更新工程")
    @PutMapping("/updateProject")
    public ApiResult<?> updateProject(@RequestBody Project project){
        if (projectService.updateProject(project)){
            System.out.println(project);
            return success("更新成功");
        }
        return fail("更新失败");

    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加工程")
    @PutMapping("/addProject")
    public ApiResult<?> addProject(@RequestBody Project project){
        System.out.println(project.getProjectid());
        if (projectService.addProject(project)){
            return success("新增成功");
        }
        return fail("新增失败");

    }
//    @PreAuthorize("hasAuthority('project:project:update')")
//    @OperationLog
//    @ApiOperation("修改")
//    @PutMapping()
//    public ApiResult<?> update(@RequestBody Project project) {
//        if (projectService.updateById(project)) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('project:project:remove')")
//    @OperationLog
//    @ApiOperation("删除")
//    @DeleteMapping("/{id}")
//    public ApiResult<?> remove(@PathVariable("id") Integer id) {
//        if (projectService.removeById(id)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }
//
//    @PreAuthorize("hasAuthority('project:project:save')")
//    @OperationLog
//    @ApiOperation("批量添加")
//    @PostMapping("/batch")
//    public ApiResult<?> saveBatch(@RequestBody List<Project> list) {
//        if (projectService.saveBatch(list)) {
//            return success("添加成功");
//        }
//        return fail("添加失败");
//    }
//
//    @PreAuthorize("hasAuthority('project:project:update')")
//    @OperationLog
//    @ApiOperation("批量修改")
//    @PutMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody BatchParam<Project> batchParam) {
//        if (batchParam.update(projectService, "projectId")) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
//    }
//
//    @PreAuthorize("hasAuthority('project:project:remove')")
//    @OperationLog
//    @ApiOperation("批量删除")
//    @DeleteMapping("/batch")
//    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
//        if (projectService.removeByIds(ids)) {
//            return success("删除成功");
//        }
//        return fail("删除失败");
//    }

}
