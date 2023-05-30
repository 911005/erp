package com.eleadmin.ConvoyManagement.tanker.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.ConvoyManagement.tanker.mapper.TankerMapper;
import com.eleadmin.ConvoyManagement.tanker.service.TankerService;
import com.eleadmin.ConvoyManagement.tanker.entity.Tanker;
import com.eleadmin.ConvoyManagement.tanker.param.TankerParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-13 15:42:42
 */
@Service
public class TankerServiceImpl extends ServiceImpl<TankerMapper, Tanker> implements TankerService {

    @Autowired
    TankerMapper tankerMapper;

    @Override
    public PageResult<Tanker> pageRel(TankerParam param) {
        PageParam<Tanker, TankerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Tanker> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Tanker> listRel(TankerParam param) {
        List<Tanker> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Tanker, TankerParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Tanker getByIdRel(Integer id) {
        TankerParam param = new TankerParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Tanker> findTankersBytankCarId(String id) {
        return tankerMapper.findTankersBytankCarId(id);
    }

    @Override
    public List<Tanker> findTankersBytankCarNumber(String number) {
        return tankerMapper.findTankersBytankCarNumber(number);
    }

    @Override
    public List<Tanker> findAllTankers() {
        return tankerMapper.findAllTankers();
    }

    @Override
    public void deleteTanker(int id) {
    tankerMapper.deleteTanker(id);
    }

    @Override
    public boolean addTanker(Tanker tanker) {
        System.out.println(tanker.getTankcarid());
        tankerMapper.addTanker(tanker);
        return true;
    }

    @Override
    public boolean updateTanker(Tanker tanker) {
        tankerMapper.updateTanker(tanker);
        System.out.println(tanker.getTankcarid());
        return true;
    }


}
