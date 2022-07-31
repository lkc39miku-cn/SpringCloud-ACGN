package com.hikari.controller;

import com.hikari.entity.User;
import com.hikari.result.Result;
import com.hikari.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (spring_cloud.`user`)表控制层
 *
 * @author lkc39miku_cn
 */
@RestController
@RequestMapping("/spring_cloud.`user`")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("select/{id}")
    public Result<User> selectOne(@PathVariable(value = "id") String id) {
        return Result.success(userServiceImpl.selectByPrimaryKey(id));
    }

}
