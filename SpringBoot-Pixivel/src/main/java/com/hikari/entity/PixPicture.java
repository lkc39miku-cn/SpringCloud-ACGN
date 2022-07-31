package com.hikari.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;


/**
 * PixPicture
 * @author lkc39miku_cn
 */  
@ApiModel(value="spring_cloud.pix_picture")
@Data
public class PixPicture implements Serializable {
    /**
    * 主键 雪花
    */
    @ApiModelProperty(value="主键 雪花")
    private String id;

    /**
    * 排序
    */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
    * 外键 图片集合
    */
    @ApiModelProperty(value="外键 图片集合")
    private String pictureCollectionId;

    private static final long serialVersionUID = 1L;
}