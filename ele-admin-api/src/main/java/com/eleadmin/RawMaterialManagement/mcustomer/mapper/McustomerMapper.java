package com.eleadmin.RawMaterialManagement.mcustomer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import com.eleadmin.RawMaterialManagement.mcustomer.param.McustomerParam;
import com.eleadmin.RawMaterialManagement.supplier.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-06-04 21:55:35
 */
public interface McustomerMapper extends BaseMapper<Mcustomer> {

    void updateMcustomer(Mcustomer mcustomer);
    void addMcustomer(Mcustomer mcustomer);
    void deleteMcustomer(int id);

    List<Mcustomer>findAllMcustomer();

    List<Mcustomer> findMcustomerByName(String name);
    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Mcustomer>
     */
    List<Mcustomer> selectPageRel(@Param("page") IPage<Mcustomer> page,
                             @Param("param") McustomerParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Mcustomer> selectListRel(@Param("param") McustomerParam param);

}
