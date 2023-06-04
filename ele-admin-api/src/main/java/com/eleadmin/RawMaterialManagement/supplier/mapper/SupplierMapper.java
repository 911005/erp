package com.eleadmin.RawMaterialManagement.supplier.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.RawMaterialManagement.supplier.entity.Supplier;
import com.eleadmin.RawMaterialManagement.supplier.param.SupplierParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-06-03 22:38:26
 */
public interface SupplierMapper extends BaseMapper<Supplier> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Supplier>
     */
    List<Supplier> selectPageRel(@Param("page") IPage<Supplier> page,
                             @Param("param") SupplierParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Supplier> selectListRel(@Param("param") SupplierParam param);

    List<SupplierParam> findAllSuppliers();

    List<SupplierParam> findByName(String name);

    List<SupplierParam> findBySaleman(String saleman);

    void updateSupplier(Supplier supplier);

    void addSupplier(Supplier supplier);

    void deleteSupplier(int id);
}
