package com.hikari.service;

import java.util.List;
import com.hikari.entity.PixPicture;
    
/**
 * PixPictureService
 * @author lkc39miku_cn
 */  
public interface PixPictureService{


    int deleteByPrimaryKey(String id);

    int insert(PixPicture record);

    PixPicture selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PixPicture record);

    int updateBatchSelective(List<PixPicture> list);

    int batchInsert(List<PixPicture> list);

}
