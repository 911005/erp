package com.eleadmin.sypplymaterials.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.sypplymaterials.mapper.SupplymaterialsMapper;
import com.eleadmin.sypplymaterials.service.SupplymaterialsService;
import com.eleadmin.sypplymaterials.entity.Supplymaterials;
import com.eleadmin.sypplymaterials.param.SupplymaterialsParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-04-26 15:59:35
 */
@Service
public class SupplymaterialsServiceImpl extends ServiceImpl<SupplymaterialsMapper, Supplymaterials> implements SupplymaterialsService {


    @Autowired
    SupplymaterialsMapper supplymaterialsMapper;
    @Override
    public PageResult<Supplymaterials> pageRel(SupplymaterialsParam param) {
        PageParam<Supplymaterials, SupplymaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Supplymaterials> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Supplymaterials> listRel(SupplymaterialsParam param) {
        List<Supplymaterials> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Supplymaterials, SupplymaterialsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Supplymaterials getByIdRel(Integer meterialid) {
        SupplymaterialsParam param = new SupplymaterialsParam();
        param.setMeterialid(meterialid);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Supplymaterials> findAllSupplyM() {
        return supplymaterialsMapper.findAllSupplyM();
    }

    @Override
    public List<Supplymaterials> findSupplyMById(String supplymaterialname) {
        return supplymaterialsMapper.findSupplyMById(supplymaterialname);
    }

    @Override
    public void deleteSupplyM(int id) {
        supplymaterialsMapper.deleteSupplyM(id);
    }

    @Override
    public boolean addSupplyM(Supplymaterials supplymaterials) {
        System.out.println(supplymaterials.getSupplymaterialname());
        supplymaterialsMapper.addSupplyM(supplymaterials);
        return true;
    }

    @Override
    public boolean updateSupplyM(Supplymaterials supplymaterials) {
        supplymaterialsMapper.updateSupplyM(supplymaterials);
        System.out.println(supplymaterials.getSupplymaterialname());
        return true;
    }

}
