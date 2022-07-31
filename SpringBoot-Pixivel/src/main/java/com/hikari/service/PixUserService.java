package com.hikari.service;

import java.util.List;
import com.hikari.entity.PixUser;

/**
 * PixUserService
 *
 * @author lkc39miku_cn
 */
public interface PixUserService {


    int deleteByPrimaryKey(String id);

    int insert(PixUser record);

    PixUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PixUser record);

    int batchInsert(List<PixUser> list);

    int updateBatchSelective(List<PixUser> list);

    List<PixUser> selectAll(PixUser pixUser);
}

