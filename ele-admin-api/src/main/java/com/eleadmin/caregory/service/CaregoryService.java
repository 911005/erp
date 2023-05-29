package com.eleadmin.caregory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.caregory.entity.Caregory;
import com.eleadmin.caregory.param.CaregoryParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-28 18:23:59
 */
public interface CaregoryService extends IService<Caregory> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Caregory>
     */
    PageResult<Caregory> pageRel(CaregoryParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Caregory>
     */
    List<Caregory> listRel(CaregoryParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Caregory
     */
    Caregory getByIdRel(Integer id);

    List<Caregory> findAllCaregorys();

    boolean addCaregory(Caregory caregory);

    void deleteCaregory(String subcaregory);

    boolean updateCaregory(Caregory caregory);

}
