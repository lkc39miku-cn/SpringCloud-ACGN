package com.hikari.mapper;

import com.hikari.entity.PixUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * PixUserMapper
 * @author lkc39miku_cn
 */  
@Mapper
public interface PixUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(PixUser record);

    PixUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PixUser record);

    int updateBatchSelective(List<PixUser> list);

    int batchInsert(@Param("list") List<PixUser> list);

    List<PixUser> selectAll(PixUser pixUser);
}