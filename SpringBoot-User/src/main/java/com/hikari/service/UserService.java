package com.hikari.service;

import java.util.List;
import com.hikari.entity.User;
    
/**
 * UserService
 * @author lkc39miku_cn
 */  
public interface UserService{


    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateBatchSelective(List<User> list);

    int batchInsert(List<User> list);

}
