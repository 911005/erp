package com.eleadmin.BasicInformationManagement.materials.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.BasicInformationManagement.materials.entity.Materials;
import com.eleadmin.BasicInformationManagement.materials.param.MaterialsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-29 16:16:43
 */
public interface MaterialsMapper extends BaseMapper<Materials> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Materials>
     */
    List<Materials> selectPageRel(@Param("page") IPage<Materials> page,
                             @Param("param") MaterialsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Materials> selectListRel(@Param("param") MaterialsParam param);

    List<Materials> findmaterialsByCaregory(int caregoryid);

    List<Materials> findmaterials();

    void updateMaterials(Materials materials);

    void deleltematerials(String rawname);

    void addmaterials(Materials materials);
}
