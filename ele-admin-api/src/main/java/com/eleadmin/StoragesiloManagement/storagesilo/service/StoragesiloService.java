package com.eleadmin.StoragesiloManagement.storagesilo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.StoragesiloManagement.storagesilo.entity.Storagesilo;
import com.eleadmin.StoragesiloManagement.storagesilo.param.StoragesiloParam;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-14 11:24:51
 */
public interface StoragesiloService extends IService<Storagesilo> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Storagesilo>
     */
    PageResult<Storagesilo> pageRel(StoragesiloParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Storagesilo>
     */
    List<Storagesilo> listRel(StoragesiloParam param);

    /**
     * 根据id查询
     *
     * @param id id
     * @return Storagesilo
     */
    Storagesilo getByIdRel(Integer id);

    List<Storagesilo> findStoragesilosBystoragesiloName(String name);

    List<Storagesilo> findStoragesilosBystorageslioType(String type);

    List<Storagesilo> findAllStoragesilos();

    void deleteStoragesilo(int id);

    boolean updateStoragesilo(Storagesilo storagesilo);

    boolean addStoragesilo(Storagesilo storagesilo);

}
