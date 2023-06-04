package com.eleadmin.BasicInformationManagement.production.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.BasicInformationManagement.production.entity.Production;
import com.eleadmin.BasicInformationManagement.production.param.ProductionParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-28 16:40:05
 */
public interface ProductionService extends IService<Production> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Production>
     */
    PageResult<Production> pageRel(ProductionParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Production>
     */
    List<Production> listRel(ProductionParam param);

    /**
     * 根据id查询
     *
     * @param propertyid 节点ID，主键
     * @return Production
     */
    Production getByIdRel(Integer propertyid);

    List<Production> findAllProductions();

    List<Production> findProductionsToOrder();

    Production findProductionsByid(int id);
    void deleteProduction(int id);
    boolean updateProduction(Production production);
    boolean addProduction(Production production);

}
