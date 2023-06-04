package com.eleadmin.SalesManagement.salesContract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.RawMaterialManagement.sypplymaterials.entity.Supplymaterials;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.SalesManagement.salesContract.entity.Salescontract;
import com.eleadmin.SalesManagement.salesContract.param.SalescontractParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-29 17:25:40
 */
public interface SalescontractService extends IService<Salescontract> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Salescontract>
     */
    PageResult<Salescontract> pageRel(SalescontractParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Salescontract>
     */
    List<Salescontract> listRel(SalescontractParam param);

    /**
     * 根据id查询
     *
     * @param salescontractid id
     * @return Salescontract
     */
    Salescontract getByIdRel(Integer salescontractid);

    List<SalescontractParam> findAllSalescontracts();
    List<SalescontractParam>findSalescontractsByNumber(String number);

    boolean addSalescontract(Salescontract salescontract);

    boolean updateSalescontract(Salescontract salescontract);

    void deleteSalescontract(int salescontractId);


}
