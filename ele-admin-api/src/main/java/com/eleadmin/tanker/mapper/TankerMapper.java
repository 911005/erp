package com.eleadmin.tanker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.tanker.entity.Tanker;
import com.eleadmin.tanker.param.TankerParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-13 15:42:42
 */
public interface TankerMapper extends BaseMapper<Tanker> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Tanker>
     */
    List<Tanker> selectPageRel(@Param("page") IPage<Tanker> page,
                             @Param("param") TankerParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Tanker> selectListRel(@Param("param") TankerParam param);

    List<Tanker> findAllTankers();

    void deleteTanker(int id);

    void addTanker(Tanker tanker);

    void updateTanker(Tanker tanker);
}
