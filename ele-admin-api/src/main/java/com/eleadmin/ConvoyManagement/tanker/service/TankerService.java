package com.eleadmin.ConvoyManagement.tanker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.ConvoyManagement.tanker.entity.Tanker;
import com.eleadmin.ConvoyManagement.tanker.param.TankerParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-13 15:42:42
 */
public interface TankerService extends IService<Tanker> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Tanker>
     */
    PageResult<Tanker> pageRel(TankerParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Tanker>
     */
    List<Tanker> listRel(TankerParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Tanker
     */
    Tanker getByIdRel(Integer id);

    List<Tanker> findTankersBytankCarId(String id);

    List<Tanker> findTankersBytankCarNumber(String number);


    List<Tanker> findAllTankers();

    void deleteTanker(int id);

    boolean addTanker(Tanker tanker);

    boolean updateTanker(Tanker tanker);
}
