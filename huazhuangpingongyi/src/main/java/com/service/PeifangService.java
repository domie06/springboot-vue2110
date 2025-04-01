package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeifangEntity;
import java.util.Map;

/**
 * 配方 服务类
 * @author 
 * @since 2021-03-25
 */
public interface PeifangService extends IService<PeifangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}