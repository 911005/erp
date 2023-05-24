package com.eleadmin.pumpTruck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.pumpTruck.entity.Pumptruck;
import com.eleadmin.pumpTruck.param.PumptruckParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-13 17:32:14
 */
public interface PumptruckMapper extends BaseMapper<Pumptruck> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Pumptruck>
     */
    List<Pumptruck> selectPageRel(@Param("page") IPage<Pumptruck> page,
                             @Param("param") PumptruckParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Pumptruck> selectListRel(@Param("param") PumptruckParam param);

    List<Pumptruck> findAllPumpTrucks();

    void deletePumpTruck(int id);

    void updatePumpTruck(Pumptruck pumptruck);

    void addPumpTruck(Pumptruck pumptruck);

}
