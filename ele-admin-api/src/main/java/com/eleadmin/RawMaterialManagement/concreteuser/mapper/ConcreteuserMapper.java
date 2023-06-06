package com.eleadmin.RawMaterialManagement.concreteuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.RawMaterialManagement.concreteuser.entity.Concreteuser;
import com.eleadmin.RawMaterialManagement.concreteuser.param.ConcreteuserParam;
import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-06-05 11:45:54
 */
public interface ConcreteuserMapper extends BaseMapper<Concreteuser> {

    void updateConcreteuser(Concreteuser concreteuser);
    void addConcreteuser(Concreteuser concreteuser);
    void deleteConcreteuser(int id);
    List<Concreteuser>findAllConcreteuser();


    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Concreteuser>
     */
    List<Concreteuser> selectPageRel(@Param("page") IPage<Concreteuser> page,
                             @Param("param") ConcreteuserParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Concreteuser> selectListRel(@Param("param") ConcreteuserParam param);

}
