package com.eleadmin.BasicInformationManagement.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.BasicInformationManagement.production.mapper.ProductionMapper;
import com.eleadmin.BasicInformationManagement.production.service.ProductionService;
import com.eleadmin.BasicInformationManagement.production.entity.Production;
import com.eleadmin.BasicInformationManagement.production.param.ProductionParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-28 16:40:05
 */
@Service
public class ProductionServiceImpl extends ServiceImpl<ProductionMapper, Production> implements ProductionService {

    @Override
    public PageResult<Production> pageRel(ProductionParam param) {
        PageParam<Production, ProductionParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Production> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Production> listRel(ProductionParam param) {
        List<Production> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Production, ProductionParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Production getByIdRel(Integer propertyid) {
        ProductionParam param = new ProductionParam();
        param.setPropertyid(propertyid);
        return param.getOne(baseMapper.selectListRel(param));
    }
    @Autowired
    private ProductionMapper productionMapper;
    @Override
    public List<Production> findAllProductions() {
        return productionMapper.findAllProductions();
    }

    @Override
    public List<Production> findProductionsToOrder() {
        return productionMapper.findProductionsToOrder();
    }

    @Override
    public Production findProductionsByid(int id) {
        return productionMapper.findProductionsByid(id);
    }

    @Override
    public void deleteProduction(int id) {
        productionMapper.deleteProduction(id);
    }

    @Override
    public boolean updateProduction(Production production) {
        productionMapper.updateProduction(production);
        System.out.println(production.getPropertyname());
        return true;
    }

    @Override
    public boolean addProduction(Production production) {
        System.out.println(production.getPropertyname());
        productionMapper.addProduction(production);
        return true;
    }

}
