package com.eleadmin.BasicInformationManagement.caregory.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.BasicInformationManagement.caregory.entity.Caregory;
import com.eleadmin.BasicInformationManagement.caregory.mapper.CaregoryMapper;
import com.eleadmin.BasicInformationManagement.caregory.param.CaregoryParam;
import com.eleadmin.BasicInformationManagement.caregory.service.CaregoryService;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-28 18:23:59
 */
@Service
public class CaregoryServiceImpl extends ServiceImpl<CaregoryMapper, Caregory> implements CaregoryService {

    @Autowired
    CaregoryMapper caregoryMapper;

    @Override
    public PageResult<Caregory> pageRel(CaregoryParam param) {
        PageParam<Caregory, CaregoryParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Caregory> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Caregory> listRel(CaregoryParam param) {
        List<Caregory> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Caregory, CaregoryParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Caregory getByIdRel(Integer id) {
        CaregoryParam param = new CaregoryParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Caregory> findAllCaregorys() {
        return caregoryMapper.findAllCaregorys();
    }

    @Override
    public List<Caregory> findCaregorys() {
        return caregoryMapper.findCaregorys();
    }

    @Override
    public Caregory findCaregorysByid(int id) {
        return caregoryMapper.findCaregorysByid(id);
    }

    @Override
    public boolean addCaregory(Caregory caregory) {
        System.out.println(caregory.getCaregory());
        caregoryMapper.addCaregory(caregory);
        return true;
    }

    @Override
    public void deleteCaregory(String subcaregory) {
        caregoryMapper.deleteCaregory(subcaregory);
    }

    @Override
    public boolean updateCaregory(Caregory caregory) {
        caregoryMapper.updateCaregory(caregory);
        System.out.println(caregory.getCaregory());
        return true;
    }

}
