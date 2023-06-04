package com.eleadmin.RawMaterialManagement.supplier.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.RawMaterialManagement.supplier.entity.Supplier;
import com.eleadmin.RawMaterialManagement.supplier.param.SupplierParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-06-03 22:38:26
 */
public interface SupplierService extends IService<Supplier> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Supplier>
     */
    PageResult<Supplier> pageRel(SupplierParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Supplier>
     */
    List<Supplier> listRel(SupplierParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Supplier
     */
    Supplier getByIdRel(Integer id);



    List<SupplierParam> findAllSuppliers();

    List<SupplierParam> findByName(String name);

    List<SupplierParam> findBySaleman(String saleman);

    boolean updateSupplier(Supplier supplier);

    boolean addSupplier(Supplier supplier);

    void deleteSupplier(int id);

}
