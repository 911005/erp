package com.eleadmin.RawMaterialManagement.mcustomer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.RawMaterialManagement.mcustomer.mapper.McustomerMapper;
import com.eleadmin.RawMaterialManagement.mcustomer.service.McustomerService;
import com.eleadmin.RawMaterialManagement.mcustomer.entity.Mcustomer;
import com.eleadmin.RawMaterialManagement.mcustomer.param.McustomerParam;

import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-06-04 21:55:35
 */
@Service
public class McustomerServiceImpl extends ServiceImpl<McustomerMapper, Mcustomer> implements McustomerService {
    @Autowired
    private McustomerMapper mcustomerMapper ;
    //查询所有客户
    @Override
   public List<Mcustomer> findAllMcustomer(){
        return mcustomerMapper.findAllMcustomer();
    }
    @Override
    public PageResult<Mcustomer> pageRel(McustomerParam param) {
        PageParam<Mcustomer, McustomerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Mcustomer> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Mcustomer> listRel(McustomerParam param) {
        List<Mcustomer> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Mcustomer, McustomerParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }
    @Override
    public void deleteMcustomer(int id){
        mcustomerMapper.deleteMcustomer(id);
    }

    @Override
    public boolean updateMcustomer(Mcustomer mcustomer) {
        mcustomerMapper.updateMcustomer(mcustomer);
        System.out.println(mcustomer.getId());
        return true;
    }
    @Override
    public boolean addMcustomer(Mcustomer mcustomer) {
//        System.out.println(mcustomer.getId());
        mcustomerMapper.addMcustomer(mcustomer);
        return true;
    }

    @Override
    public Mcustomer getByIdRel(Integer id) {
        McustomerParam param = new McustomerParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
