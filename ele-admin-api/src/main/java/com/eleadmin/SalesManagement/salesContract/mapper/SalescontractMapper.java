package com.eleadmin.SalesManagement.salesContract.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.SalesManagement.salesContract.entity.Salescontract;
import com.eleadmin.SalesManagement.salesContract.param.SalescontractParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-29 17:25:40
 */
public interface SalescontractMapper extends BaseMapper<Salescontract> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Salescontract>
     */
    List<Salescontract> selectPageRel(@Param("page") IPage<Salescontract> page,
                             @Param("param") SalescontractParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Salescontract> selectListRel(@Param("param") SalescontractParam param);

    List<SalescontractParam> findAllSalescontracts();
    //    根据合同编号查找
    List<SalescontractParam>findSalescontractsByNumber(String number);

    void addSalescontract(Salescontract salescontract);

    void updateSalescontract(Salescontract salescontract);

    void deleteSalescontract(int salescontractId);
}
