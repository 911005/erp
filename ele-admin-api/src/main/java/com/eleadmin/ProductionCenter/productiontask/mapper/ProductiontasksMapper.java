package com.eleadmin.ProductionCenter.productiontask.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.ProductionCenter.productiontask.entity.Productiontasks;
import com.eleadmin.ProductionCenter.productiontask.param.ProductiontasksParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-06-03 15:41:20
 */
public interface ProductiontasksMapper extends BaseMapper<Productiontasks> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Productiontasks>
     */
    List<Productiontasks> selectPageRel(@Param("page") IPage<Productiontasks> page,
                             @Param("param") ProductiontasksParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<ProductiontasksParam> selectListRel(@Param("param") ProductiontasksParam param);


    List<ProductiontasksParam> findAllProductiontasks();
    List<ProductiontasksParam> findProductionTasksByMnumber(String mnumber);

    void deleteProductiontasks(int id);

    void updateProductiontasks(Productiontasks productiontasks);

    void addProductiontasks(Productiontasks productiontasks);
}
