package com.eleadmin.SalesManagement.project.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eleadmin.SalesManagement.project.entity.Project;
import com.eleadmin.SalesManagement.project.param.ProjectParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-17 16:03:03
 */
public interface ProjectService extends IService<Project> {


    /**
     * 查询
     * @return
     */
    List< Project> findAllProject();

    List<Project> findProjectsByprojectName(String pname);

    List<Project> findProjectsBycustomerName(String name);
    /**
     * 删除
     * @param projectId
     * @return
     */
    public void deleteProject(int projectId);

    /**
     * 更新
     */
    boolean updateProject(Project project);

    boolean addProject(Project project);

}
