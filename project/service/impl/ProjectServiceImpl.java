package com.eleadmin.SalesManagement.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eleadmin.SalesManagement.project.mapper.ProjectMapper;
import com.eleadmin.SalesManagement.project.service.ProjectService;
import com.eleadmin.SalesManagement.project.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-17 16:03:03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {


    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findAllProject() {
        return projectMapper.findAllProject();
    }

    @Override
    public void deleteProject(int projectId) {
        projectMapper.deleteProject(projectId);
    }

    @Override
    public boolean updateProject(Project project) {
        projectMapper.updateProject(project);
        System.out.println(project.getProjectid());
        return true;
    }

    @Override
    public boolean addProject(Project project) {
        System.out.println(project.getProjectid());
        projectMapper.addProject(project);
        return true;
    }

}
