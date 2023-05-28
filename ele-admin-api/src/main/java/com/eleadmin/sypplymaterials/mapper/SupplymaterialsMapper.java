package com.eleadmin.sypplymaterials.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.sypplymaterials.entity.Supplymaterials;
import com.eleadmin.sypplymaterials.param.SupplymaterialsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-04-26 15:59:35
 */
public interface SupplymaterialsMapper extends BaseMapper<Supplymaterials> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Supplymaterials>
     */
    List<Supplymaterials> selectPageRel(@Param("page") IPage<Supplymaterials> page,
                             @Param("param") SupplymaterialsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Supplymaterials> selectListRel(@Param("param") SupplymaterialsParam param);

    List<Supplymaterials> findAllSupplyM();

    void deleteSupplyM(int id);

    void addSupplyM(Supplymaterials supplymaterials);

    void updateSupplyM(Supplymaterials supplymaterials);

    List<Supplymaterials> findSupplyMById(String supplymaterialname);
}
