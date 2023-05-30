package com.eleadmin.caregory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.caregory.entity.Caregory;
import com.eleadmin.caregory.param.CaregoryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-28 18:23:59
 */
public interface CaregoryMapper extends BaseMapper<Caregory> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Caregory>
     */
    List<Caregory> selectPageRel(@Param("page") IPage<Caregory> page,
                             @Param("param") CaregoryParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Caregory> selectListRel(@Param("param") CaregoryParam param);

    List<Caregory> findAllCaregorys();

    void addCaregory(Caregory caregory);

    void deleteCaregory(String caregory);

    void updateCaregory(Caregory caregory);

}
