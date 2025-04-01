package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.HuazhuangpinEntity;

import com.service.HuazhuangpinService;
import com.entity.view.HuazhuangpinView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 化妆品
 * 后端接口
 * @author
 * @email
 * @date 2021-03-25
*/
@RestController
@Controller
@RequestMapping("/huazhuangpin")
public class HuazhuangpinController {
    private static final Logger logger = LoggerFactory.getLogger(HuazhuangpinController.class);

    @Autowired
    private HuazhuangpinService huazhuangpinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = huazhuangpinService.queryPage(params);

        //字典表数据转换
        List<HuazhuangpinView> list =(List<HuazhuangpinView>)page.getList();
        for(HuazhuangpinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuazhuangpinEntity huazhuangpin = huazhuangpinService.selectById(id);
        if(huazhuangpin !=null){
            //entity转view
            HuazhuangpinView view = new HuazhuangpinView();
            BeanUtils.copyProperties( huazhuangpin , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuazhuangpinEntity huazhuangpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huazhuangpin:{}",this.getClass().getName(),huazhuangpin.toString());
        Wrapper<HuazhuangpinEntity> queryWrapper = new EntityWrapper<HuazhuangpinEntity>()
            .eq("kzpname", huazhuangpin.getKzpname())
            .eq("pinpai_types", huazhuangpin.getPinpaiTypes())
            .eq("leixing_types", huazhuangpin.getLeixingTypes())
            .eq("gongyi_types", huazhuangpin.getGongyiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuazhuangpinEntity huazhuangpinEntity = huazhuangpinService.selectOne(queryWrapper);
        if(huazhuangpinEntity==null){
            huazhuangpin.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      huazhuangpin.set
        //  }
            huazhuangpinService.insert(huazhuangpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuazhuangpinEntity huazhuangpin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huazhuangpin:{}",this.getClass().getName(),huazhuangpin.toString());
        //根据字段查询是否有相同数据
        Wrapper<HuazhuangpinEntity> queryWrapper = new EntityWrapper<HuazhuangpinEntity>()
            .notIn("id",huazhuangpin.getId())
            .andNew()
            .eq("kzpname", huazhuangpin.getKzpname())
            .eq("pinpai_types", huazhuangpin.getPinpaiTypes())
            .eq("leixing_types", huazhuangpin.getLeixingTypes())
            .eq("gongyi_types", huazhuangpin.getGongyiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuazhuangpinEntity huazhuangpinEntity = huazhuangpinService.selectOne(queryWrapper);
        if("".equals(huazhuangpin.getImgPhoto()) || "null".equals(huazhuangpin.getImgPhoto())){
                huazhuangpin.setImgPhoto(null);
        }
        if(huazhuangpinEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      huazhuangpin.set
            //  }
            huazhuangpinService.updateById(huazhuangpin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huazhuangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

