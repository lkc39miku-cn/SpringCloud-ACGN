package com.hikari.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.hikari.mapper.PixUserMapper;
import com.hikari.entity.PixUser;
import com.hikari.service.PixUserService;

/**
 * PixUserServiceImpl
 * @author lkc39miku_cn
 */
@Service
public class PixUserServiceImpl implements PixUserService {

    @Resource
    private PixUserMapper pixUserMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return pixUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PixUser record) {
        return pixUserMapper.insert(record);
    }

    @Override
    public PixUser selectByPrimaryKey(String id) {
        return pixUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PixUser record) {
        return pixUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int batchInsert(List<PixUser> list) {
        return pixUserMapper.batchInsert(list);
    }

    @Override
    public int updateBatchSelective(List<PixUser> list) {
        return pixUserMapper.updateBatchSelective(list);
    }

    @Override
    public List<PixUser> selectAll(PixUser pixUser) {
        return pixUserMapper.selectAll(pixUser);
    }
}

