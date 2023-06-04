package com.eleadmin.RawMaterialManagement.material.service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.RawMaterialManagement.material.entity.Material;
import com.eleadmin.RawMaterialManagement.material.param.MaterialParam;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-31 09:31:17
 */
public interface MaterialService extends IService<Material> {
    /**
     * 查询
     * @return
     */
    List<Material> findAllMA();
    List<Material> findMABysupplier(String supplier);
    List<Material> findMAByPtime(DateTime datetime);
    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteMaterial(int id);

    /**
     * 更新
     */
    boolean updateMaterial(Material material);

    boolean addMaterial(Material material);

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Material>
     */
    PageResult<Material> pageRel(MaterialParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Material>
     */
    List<Material> listRel(MaterialParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Material
     */
    Material getByIdRel(Integer id);

}
