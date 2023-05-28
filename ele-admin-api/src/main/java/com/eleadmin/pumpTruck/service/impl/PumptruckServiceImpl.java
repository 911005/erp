package com.eleadmin.pumpTruck.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.pumpTruck.mapper.PumptruckMapper;
import com.eleadmin.pumpTruck.service.PumptruckService;
import com.eleadmin.pumpTruck.entity.Pumptruck;
import com.eleadmin.pumpTruck.param.PumptruckParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-13 17:32:14
 */
@Service
public class PumptruckServiceImpl extends ServiceImpl<PumptruckMapper, Pumptruck> implements PumptruckService {

    @Autowired
    PumptruckMapper pumptruckMapper;

    @Override
    public PageResult<Pumptruck> pageRel(PumptruckParam param) {
        PageParam<Pumptruck, PumptruckParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Pumptruck> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Pumptruck> listRel(PumptruckParam param) {
        List<Pumptruck> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Pumptruck, PumptruckParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Pumptruck getByIdRel(Integer id) {
        PumptruckParam param = new PumptruckParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Pumptruck> findAllPumpTrucks() {
        return pumptruckMapper.findAllPumpTrucks();
    }

    @Override
    public List<Pumptruck> findPumpTrucksBypumpTruckNumber(String number) {
        return pumptruckMapper.findPumpTrucksBypumpTruckNumber(number);
    }

    @Override
    public List<Pumptruck> findPumpTrucksBypumpTruckid(String id) {
        return pumptruckMapper.findPumpTrucksBypumpTruckid(id);
    }

    @Override
    public void deletePumpTruck(int id) {
        pumptruckMapper.deletePumpTruck(id);
    }

    @Override
    public boolean updatePumpTruck(Pumptruck pumptruck) {
        pumptruckMapper.updatePumpTruck(pumptruck);
        System.out.println(pumptruck.getPumptruckid());
        return true;
    }

    @Override
    public boolean addPumpTruck(Pumptruck pumptruck) {
        System.out.println(pumptruck.getPumptruckid());
        pumptruckMapper.addPumpTruck(pumptruck);
        return true;
    }

}
