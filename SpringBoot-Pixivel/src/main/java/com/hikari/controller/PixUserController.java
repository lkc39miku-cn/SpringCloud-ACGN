package com.hikari.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hikari.entity.Page;
import com.hikari.entity.PixUser;
import com.hikari.result.Result;
import com.hikari.service.impl.PixUserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (spring_cloud.pix_user)表控制层
 * @author lkc39miku_cn
 */
@RestController
@RequestMapping("/spring_cloud.pix_user")
public class PixUserController {
    /**
     * 服务对象
     */
    @Resource
    private PixUserServiceImpl pixUserServiceImpl;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("select/{id}")
    public Result<PixUser> selectOne(@PathVariable(value = "id") String id) {
        return Result.success(pixUserServiceImpl.selectByPrimaryKey(id));
    }

    /**
     * 查询所有数据
     * @param pixUser 实体对象
     * @return 所有数据
     */
    @GetMapping("select")
    public Result<List<PixUser>> selectList(PixUser pixUser) {
        PageInfo<PixUser> pageInfo = PageHelper.startPage(Page.page(), Page.pageSize()).doSelectPageInfo(() -> pixUserServiceImpl.selectAll(pixUser));
        return Result.success(pageInfo.getList(), pageInfo.getTotal());
    }
}
