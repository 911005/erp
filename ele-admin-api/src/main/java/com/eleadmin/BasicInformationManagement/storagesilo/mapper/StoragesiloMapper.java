package com.eleadmin.BasicInformationManagement.storagesilo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.BasicInformationManagement.storagesilo.entity.Storagesilo;
import com.eleadmin.BasicInformationManagement.storagesilo.param.StoragesiloParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-14 11:24:51
 */
public interface StoragesiloMapper extends BaseMapper<Storagesilo> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Storagesilo>
     */
    List<Storagesilo> selectPageRel(@Param("page") IPage<Storagesilo> page,
                             @Param("param") StoragesiloParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Storagesilo> selectListRel(@Param("param") StoragesiloParam param);


    /**
     * 查询所有储粮仓信息
     */
    List<Storagesilo> findAllStoragesilos();

    List<Storagesilo> findStoragesilosBystoragesiloName(String name);

    List<Storagesilo> findStoragesilosBystorageslioType(String type);
    /**
     * 删除储料仓信息
     * @param id
     */
    void deleteStoragesilo(int id);

    /**
     * 更新储料仓信息
     * @param storagesilo
     */
    void updateStoragesilo(Storagesilo storagesilo);

    void addStoragesilo(Storagesilo storagesilo);

}
