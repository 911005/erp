package com.eleadmin.SalesManagement.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eleadmin.SalesManagement.project.entity.Project;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-17 16:03:03
 */
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 查询所有工程信息
     */
    List<Project> findAllProject();

    //    根据客户名称查找工程
    List<Project>findProjectsBycustomerName(String name);

    //    根据客户名称查找工程
    List<Project>findProjectsByprojectName(String pname);
    /**
     * 删除工程信息
     * @param projectId
     */
    void deleteProject(int projectId);

    /**
     * 更新工程信息
     * @param project
     */
    void updateProject(Project project);

    void addProject(Project project);


}
