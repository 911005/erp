package com.eleadmin.RawMaterialManagement.material.mapper;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.RawMaterialManagement.material.entity.Material;
import com.eleadmin.RawMaterialManagement.material.param.MaterialParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-31 09:31:17
 */
public interface MaterialMapper extends BaseMapper<Material> {

    List<Material>findAllMA();
    List<Material>findMAByPtime(DateTime datetime);
    List<Material> findMABysupplier(String supplier);
    void deleteMaterial(int id);
    /**
     * 更新工程信息
     * @param material
     */
    void updateMaterial(Material material);

    void addMaterial(Material material);
    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Material>
     */
    List<Material> selectPageRel(@Param("page") IPage<Material> page,
                             @Param("param") MaterialParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Material> selectListRel(@Param("param") MaterialParam param);

}
