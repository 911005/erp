package com.eleadmin.sypplymaterials.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.sypplymaterials.entity.Supplymaterials;
import com.eleadmin.sypplymaterials.param.SupplymaterialsParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-04-26 15:59:35
 */
public interface SupplymaterialsService extends IService<Supplymaterials> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Supplymaterials>
     */
    PageResult<Supplymaterials> pageRel(SupplymaterialsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Supplymaterials>
     */
    List<Supplymaterials> listRel(SupplymaterialsParam param);

    /**
     * 根据id查询
     *
     * @param meterialid 原材料id
     * @return Supplymaterials
     */
    Supplymaterials getByIdRel(Integer meterialid);



    List<Supplymaterials> findAllSupplyM();

    List<Supplymaterials> findSupplyMById(String supplymaterialname);

    void deleteSupplyM(int id);

    boolean addSupplyM(Supplymaterials supplymaterials);

    boolean updateSupplyM(Supplymaterials supplymaterials);

}
