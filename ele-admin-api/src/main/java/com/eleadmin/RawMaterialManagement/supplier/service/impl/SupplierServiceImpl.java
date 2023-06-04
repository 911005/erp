package com.eleadmin.RawMaterialManagement.supplier.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.RawMaterialManagement.supplier.mapper.SupplierMapper;
import com.eleadmin.RawMaterialManagement.supplier.service.SupplierService;
import com.eleadmin.RawMaterialManagement.supplier.entity.Supplier;
import com.eleadmin.RawMaterialManagement.supplier.param.SupplierParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-06-03 22:38:26
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public PageResult<Supplier> pageRel(SupplierParam param) {
        PageParam<Supplier, SupplierParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Supplier> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Supplier> listRel(SupplierParam param) {
        List<Supplier> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Supplier, SupplierParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Supplier getByIdRel(Integer id) {
        SupplierParam param = new SupplierParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<SupplierParam> findAllSuppliers() {
        return supplierMapper.findAllSuppliers();
    }

    @Override
    public List<SupplierParam> findByName(String name) {
        return supplierMapper.findByName(name);
    }

    @Override
    public List<SupplierParam> findBySaleman(String saleman) {
        return supplierMapper.findBySaleman(saleman);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
        System.out.println(supplier.getSuppliername());
        return true;
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        System.out.println(supplier.getSuppliername());
        supplierMapper.addSupplier(supplier);
        return true;
    }

    @Override
    public void deleteSupplier(int id) {
        supplierMapper.deleteSupplier(id);
    }

}
