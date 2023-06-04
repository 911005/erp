package com.eleadmin.ProductionCenter.productiontask.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.ProductionCenter.productiontask.entity.Productiontasks;
import com.eleadmin.ProductionCenter.productiontask.mapper.ProductiontasksMapper;
import com.eleadmin.ProductionCenter.productiontask.service.ProductiontasksService;
import com.eleadmin.ProductionCenter.productiontask.param.ProductiontasksParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-06-03 15:41:20
 */
@Service
public class ProductiontasksServiceImpl extends ServiceImpl<ProductiontasksMapper, Productiontasks> implements ProductiontasksService {
    @Autowired
    private ProductiontasksMapper productiontasksMapper;
    @Override
    public List<ProductiontasksParam> findAllProductiontasks() {
        return productiontasksMapper.findAllProductiontasks();
    }

    @Override
    public List<ProductiontasksParam> findProductionTasksByMnumber(String mnumber) {
        return productiontasksMapper.findProductionTasksByMnumber(mnumber);
    }


    @Override
    public void deleteProductiontasks(int id) {
        productiontasksMapper.deleteProductiontasks(id);
    }

    @Override
    public boolean updateProductiontasks(Productiontasks productiontasks) {
        productiontasksMapper.updateProductiontasks(productiontasks);
        System.out.println(productiontasks.getMissonid());
        return true;
    }

    @Override
    public boolean addProductiontasks(Productiontasks productiontasks) {
        System.out.println(productiontasks.getMissonid());
        productiontasksMapper.addProductiontasks(productiontasks);
        return true;
    }

//    @Override
//    public PageResult<Productiontasks> pageRel(ProductiontasksParam param) {
//        PageParam<Productiontasks, ProductiontasksParam> page = new PageParam<>(param);
//        //page.setDefaultOrder("create_time desc");
//        List<Productiontasks> list = baseMapper.selectPageRel(page, param);
//        return new PageResult<>(list, page.getTotal());
//    }
//
//    @Override
//    public List<Productiontasks> listRel(ProductiontasksParam param) {
//        List<Productiontasks> list = baseMapper.selectListRel(param);
//        // 排序
//        PageParam<Productiontasks, ProductiontasksParam> page = new PageParam<>();
//        //page.setDefaultOrder("create_time desc");
//        return page.sortRecords(list);
//    }
//
//    @Override
//    public Productiontasks getByIdRel(Integer missonid) {
//        ProductiontasksParam param = new ProductiontasksParam();
//        param.setMissonid(missonid);
//        return param.getOne(baseMapper.selectListRel(param));
//    }

}
