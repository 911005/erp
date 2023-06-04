package com.eleadmin.SalesManagement.salesContract.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.SalesManagement.salesContract.mapper.SalescontractMapper;
import com.eleadmin.SalesManagement.salesContract.service.SalescontractService;
import com.eleadmin.SalesManagement.salesContract.entity.Salescontract;
import com.eleadmin.SalesManagement.salesContract.param.SalescontractParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-29 17:25:40
 */
@Service
public class SalescontractServiceImpl extends ServiceImpl<SalescontractMapper, Salescontract> implements SalescontractService {

    @Autowired
    SalescontractMapper salescontractMapper;
    @Override
    public List<SalescontractParam> findAllSalescontracts() {
        return salescontractMapper.findAllSalescontracts();
    }

    @Override
    public List<SalescontractParam> findSalescontractsByNumber(String number) {
        return salescontractMapper.findSalescontractsByNumber(number);
    }

    @Override
    public boolean addSalescontract(Salescontract salescontract) {
        salescontractMapper.addSalescontract(salescontract);
        System.out.println(salescontract.getSalescontractid());
        return true;
    }

    @Override
    public boolean updateSalescontract(Salescontract salescontract) {
        salescontractMapper.updateSalescontract(salescontract);
        System.out.println(salescontract.getNumber());
        return true;
    }

    @Override
    public void deleteSalescontract(int salescontractId) {
        salescontractMapper.deleteSalescontract(salescontractId);
    }


    @Override
    public PageResult<Salescontract> pageRel(SalescontractParam param) {
        PageParam<Salescontract, SalescontractParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Salescontract> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Salescontract> listRel(SalescontractParam param) {
        List<Salescontract> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Salescontract, SalescontractParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Salescontract getByIdRel(Integer salescontractid) {
        SalescontractParam param = new SalescontractParam();
        param.setSalescontractid(salescontractid);
        return param.getOne(baseMapper.selectListRel(param));
    }
}
