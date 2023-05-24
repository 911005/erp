package com.eleadmin.StoragesiloManagement.storagesilo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.StoragesiloManagement.storagesilo.mapper.StoragesiloMapper;
import com.eleadmin.StoragesiloManagement.storagesilo.service.StoragesiloService;
import com.eleadmin.StoragesiloManagement.storagesilo.entity.Storagesilo;
import com.eleadmin.StoragesiloManagement.storagesilo.param.StoragesiloParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-14 11:24:51
 */
@Service
public class StoragesiloServiceImpl extends ServiceImpl<StoragesiloMapper, Storagesilo> implements StoragesiloService {

    @Override
    public PageResult<Storagesilo> pageRel(StoragesiloParam param) {
        PageParam<Storagesilo, StoragesiloParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Storagesilo> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Storagesilo> listRel(StoragesiloParam param) {
        List<Storagesilo> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Storagesilo, StoragesiloParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Storagesilo getByIdRel(Integer id) {
        StoragesiloParam param = new StoragesiloParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }



    @Autowired
    private StoragesiloMapper storagesiloMapper;
    @Override
    public List<Storagesilo> findAllStoragesilos() {
        return storagesiloMapper.findAllStoragesilos();
    }

    @Override
    public void deleteStoragesilo(int id) {
        storagesiloMapper.deleteStoragesilo(id);
    }

    @Override
    public boolean updateStoragesilo(Storagesilo storagesilo) {
        storagesiloMapper.updateStoragesilo(storagesilo);
        System.out.println(storagesilo.getStoragesiloname());
        return true;
    }

    @Override
    public boolean addStoragesilo(Storagesilo storagesilo) {
        System.out.println(storagesilo.getStoragesiloname());
        storagesiloMapper.addStoragesilo(storagesilo);
        return true;
    }

}
