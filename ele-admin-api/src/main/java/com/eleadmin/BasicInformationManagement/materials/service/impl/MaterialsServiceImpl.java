package com.eleadmin.BasicInformationManagement.materials.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.BasicInformationManagement.materials.entity.Materials;
import com.eleadmin.BasicInformationManagement.materials.mapper.MaterialsMapper;
import com.eleadmin.BasicInformationManagement.materials.param.MaterialsParam;
import com.eleadmin.BasicInformationManagement.materials.service.MaterialsService;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-29 16:16:43
 */
@Service
public class MaterialsServiceImpl extends ServiceImpl<MaterialsMapper, Materials> implements MaterialsService {

    @Autowired
    MaterialsMapper mapper;

    @Override
    public PageResult<Materials> pageRel(MaterialsParam param) {
        PageParam<Materials, MaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Materials> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Materials> listRel(MaterialsParam param) {
        List<Materials> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Materials, MaterialsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Materials getByIdRel(Integer id) {
        MaterialsParam param = new MaterialsParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Materials> findmaterials() {
        return mapper.findmaterials();
    }

    @Override
    public List<Materials> findmaterialsByCaregory(int caregoryid) {
        return mapper.findmaterialsByCaregory(caregoryid);
    }

    @Override
    public boolean updateMaterials(Materials materials) {
        mapper.updateMaterials(materials);
        System.out.println(materials.getRawname());
        return true;
    }

    @Override
    public void deleltematerials(String rawname) {
        mapper.deleltematerials(rawname);
    }

    @Override
    public boolean addmaterials(Materials materials) {
        System.out.println(materials.getRawname());
        mapper.addmaterials(materials);
        return true;
    }

}
