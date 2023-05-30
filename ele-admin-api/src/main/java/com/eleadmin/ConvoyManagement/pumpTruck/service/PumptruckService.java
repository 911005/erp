package com.eleadmin.ConvoyManagement.pumpTruck.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.ConvoyManagement.pumpTruck.entity.Pumptruck;
import com.eleadmin.ConvoyManagement.pumpTruck.param.PumptruckParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-13 17:32:14
 */
public interface PumptruckService extends IService<Pumptruck> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Pumptruck>
     */
    PageResult<Pumptruck> pageRel(PumptruckParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Pumptruck>
     */
    List<Pumptruck> listRel(PumptruckParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Pumptruck
     */
    Pumptruck getByIdRel(Integer id);

    List<Pumptruck> findAllPumpTrucks();

    List<Pumptruck> findPumpTrucksBypumpTruckNumber(String number);

    List<Pumptruck> findPumpTrucksBypumpTruckid(String id);

    void deletePumpTruck(int id);

    boolean updatePumpTruck(Pumptruck pumptruck);

    boolean addPumpTruck(Pumptruck pumptruck);
}
