package com.eleadmin.BasicInformationManagement.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.BasicInformationManagement.production.entity.Production;
import com.eleadmin.BasicInformationManagement.production.param.ProductionParam;
import com.eleadmin.BasicInformationManagement.storagesilo.entity.Storagesilo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-28 16:40:05
 */
public interface ProductionMapper extends BaseMapper<Production> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Production>
     */
    List<Production> selectPageRel(@Param("page") IPage<Production> page,
                             @Param("param") ProductionParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Production> selectListRel(@Param("param") ProductionParam param);


    List<Production> findAllProductions();

    void deleteProduction(int id);

    void updateProduction(Production production);

    void addProduction(Production production);

}
