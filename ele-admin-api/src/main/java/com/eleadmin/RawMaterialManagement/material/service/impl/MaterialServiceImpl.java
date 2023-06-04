package com.eleadmin.RawMaterialManagement.material.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.RawMaterialManagement.material.mapper.MaterialMapper;
import com.eleadmin.RawMaterialManagement.material.service.MaterialService;
import com.eleadmin.RawMaterialManagement.material.entity.Material;
import com.eleadmin.RawMaterialManagement.material.param.MaterialParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-31 09:31:17
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public List<Material> findAllMA() {
        return materialMapper.findAllMA();
    }

    @Override
     public List<Material> findMAByPtime(DateTime datetime){
        return materialMapper.findMAByPtime(datetime);
    }

    @Override
    public List<Material> findMABysupplier(String supplier){
        return materialMapper.findMABysupplier(supplier);
    }

    @Override
    public void deleteMaterial(int id){
        materialMapper.deleteMaterial(id);
    }

    @Override
    public boolean updateMaterial(Material material) {
        materialMapper.updateMaterial(material);
        System.out.println(material.getId());
        return true;
    }

    @Override
    public boolean addMaterial(Material material) {
        System.out.println(material.getId());
        materialMapper.addMaterial(material);
        return true;
    }
    @Override
    public PageResult<Material> pageRel(MaterialParam param) {
        PageParam<Material, MaterialParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Material> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Material> listRel(MaterialParam param) {
        List<Material> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Material, MaterialParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Material getByIdRel(Integer id) {
        MaterialParam param = new MaterialParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
