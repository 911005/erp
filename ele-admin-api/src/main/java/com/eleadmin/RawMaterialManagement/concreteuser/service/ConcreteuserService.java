package com.eleadmin.RawMaterialManagement.concreteuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.RawMaterialManagement.concreteuser.entity.Concreteuser;
import com.eleadmin.RawMaterialManagement.concreteuser.param.ConcreteuserParam;
import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-06-05 11:45:54
 */
public interface ConcreteuserService extends IService<Concreteuser> {

    //增加
    boolean addConcreteuser(Concreteuser concreteuser);
    //    查询
    List<Concreteuser> findAllConcreteuser();

    List<Concreteuser> findConcreteuserByName(String name);

    void deleteConcreteuser(int id);

    boolean updateConcreteuser(Concreteuser concreteuser);


    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Concreteuser>
     */
    PageResult<Concreteuser> pageRel(ConcreteuserParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Concreteuser>
     */
    List<Concreteuser> listRel(ConcreteuserParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Concreteuser
     */
    Concreteuser getByIdRel(Integer id);

}
