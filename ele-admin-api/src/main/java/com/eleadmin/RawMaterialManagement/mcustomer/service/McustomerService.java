package com.eleadmin.RawMaterialManagement.mcustomer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import com.eleadmin.RawMaterialManagement.mcustomer.param.McustomerParam;
import com.eleadmin.RawMaterialManagement.sypplymaterials.entity.Supplymaterials;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-06-04 21:55:35
 */
public interface McustomerService extends IService<Mcustomer> {

//增加
    boolean addMcustomer(Mcustomer mcustomer);
//    查询
    List<Mcustomer> findAllMcustomer();

    List<Mcustomer> findMcustomerByName(String name);

    void deleteMcustomer(int id);

    boolean updateMcustomer(Mcustomer mcustomer);


    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Mcustomer>
     */
    PageResult<Mcustomer> pageRel(McustomerParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Mcustomer>
     */
    List<Mcustomer> listRel(McustomerParam param);

    /**
     * 根据id查询
     *
     * @param id id
     * @return Mcustomer
     */
    Mcustomer getByIdRel(Integer id);

}
