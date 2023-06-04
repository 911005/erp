package com.eleadmin.ProductionCenter.productiontask.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.ProductionCenter.productiontask.entity.Productiontasks;
import com.eleadmin.ProductionCenter.productiontask.param.ProductiontasksParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-06-03 15:41:20
 */
public interface ProductiontasksService extends IService<Productiontasks> {

    List<ProductiontasksParam> findAllProductiontasks();
    List<ProductiontasksParam> findProductionTasksByMnumber(String mnumber);
    void deleteProductiontasks(int id);

    boolean updateProductiontasks(Productiontasks productiontasks);

    boolean addProductiontasks(Productiontasks productiontasks);
//    /**
//     * 分页关联查询
//     *
//     * @param param 查询参数
//     * @return PageResult<Productiontasks>
//     */
//    PageResult<Productiontasks> pageRel(ProductiontasksParam param);
//
//    /**
//     * 关联查询全部
//     *
//     * @param param 查询参数
//     * @return List<Productiontasks>
//     */
//    List<Productiontasks> listRel(ProductiontasksParam param);
//
//    /**
//     * 根据id查询
//     *
//     * @param missonid
//     * @return Productiontasks
//     */
//    Productiontasks getByIdRel(Integer missonid);

}
