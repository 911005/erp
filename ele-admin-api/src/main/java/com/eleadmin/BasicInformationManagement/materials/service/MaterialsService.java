package com.eleadmin.BasicInformationManagement.materials.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.BasicInformationManagement.materials.entity.Materials;
import com.eleadmin.BasicInformationManagement.materials.param.MaterialsParam;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-29 16:16:43
 */
public interface MaterialsService extends IService<Materials> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Materials>
     */
    PageResult<Materials> pageRel(MaterialsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Materials>
     */
    List<Materials> listRel(MaterialsParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Materials
     */
    Materials getByIdRel(Integer id);

    List<Materials> findmaterials();
    List<Materials> findmaterialsByCaregory(int caregoryid);

    boolean updateMaterials(Materials materials);

    void deleltematerials(String rawname);

    boolean addmaterials(Materials materials);

}
