package com.eleadmin.RawMaterialManagement.concreteuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.RawMaterialManagement.concreteuser.mapper.ConcreteuserMapper;
import com.eleadmin.RawMaterialManagement.concreteuser.service.ConcreteuserService;
import com.eleadmin.RawMaterialManagement.concreteuser.entity.Concreteuser;
import com.eleadmin.RawMaterialManagement.concreteuser.param.ConcreteuserParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-06-05 11:45:54
 */
@Service
public class ConcreteuserServiceImpl extends ServiceImpl<ConcreteuserMapper, Concreteuser> implements ConcreteuserService {

    @Autowired
    private ConcreteuserMapper concreteuserMapper ;
    @Override
    public PageResult<Concreteuser> pageRel(ConcreteuserParam param) {
        PageParam<Concreteuser, ConcreteuserParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Concreteuser> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Concreteuser> listRel(ConcreteuserParam param) {
        List<Concreteuser> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Concreteuser, ConcreteuserParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }
    //查询所有客户
    @Override
    public List<Concreteuser> findAllConcreteuser(){
        return concreteuserMapper.findAllConcreteuser();
    }

    @Override
    public List<Concreteuser> findConcreteuserByName(String name) {
        return concreteuserMapper.findConcreteuserByName(name);
    }

    //删除
    @Override
    public void deleteConcreteuser(int id){
        concreteuserMapper.deleteConcreteuser(id);
    }
//更新
    @Override
    public boolean updateConcreteuser(Concreteuser concreteuser) {
        concreteuserMapper.updateConcreteuser(concreteuser);
        System.out.println(concreteuser.getId());
        return true;
    }
    //增加
    @Override
    public boolean addConcreteuser(Concreteuser concreteuser) {
//        System.out.println(mcustomer.getId());
        concreteuserMapper.addConcreteuser(concreteuser);
        return true;
    }

    @Override
    public Concreteuser getByIdRel(Integer id) {
        ConcreteuserParam param = new ConcreteuserParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
