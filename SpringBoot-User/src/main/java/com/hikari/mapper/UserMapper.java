package com.hikari.mapper;

import com.hikari.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * UserMapper
 * @author lkc39miku_cn
 */  
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateBatchSelective(List<User> list);

    int batchInsert(@Param("list") List<User> list);
}