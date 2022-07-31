package com.hikari.controller;

import com.hikari.entity.PixPicture;
import com.hikari.result.Result;
import com.hikari.service.impl.PixPictureServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (spring_cloud.pix_picture)表控制层
 *
 * @author lkc39miku_cn
 */
@RestController
@RequestMapping("/spring_cloud.pix_picture")
public class PixPictureController {
    /**
     * 服务对象
     */
    @Resource
    private PixPictureServiceImpl pixPictureServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("select/{id}")
    public Result<PixPicture> selectOne(@PathVariable(value = "id") String id) {
        return Result.success(pixPictureServiceImpl.selectByPrimaryKey(id));
    }

}
