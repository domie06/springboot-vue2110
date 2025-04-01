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

import com.entity.PeifangEntity;

import com.service.PeifangService;
import com.entity.view.PeifangView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 配方
 * 后端接口
 * @author
 * @email
 * @date 2021-03-25
*/
@RestController
@Controller
@RequestMapping("/peifang")
public class PeifangController {
    private static final Logger logger = LoggerFactory.getLogger(PeifangController.class);

    @Autowired
    private PeifangService peifangService;


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
        PageUtils page = peifangService.queryPage(params);

        //字典表数据转换
        List<PeifangView> list =(List<PeifangView>)page.getList();
        for(PeifangView c:list){
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
        PeifangEntity peifang = peifangService.selectById(id);
        if(peifang !=null){
            //entity转view
            PeifangView view = new PeifangView();
            BeanUtils.copyProperties( peifang , view );//把实体数据重构到view中

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
    public R save(@RequestBody PeifangEntity peifang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,peifang:{}",this.getClass().getName(),peifang.toString());
        Wrapper<PeifangEntity> queryWrapper = new EntityWrapper<PeifangEntity>()
            .eq("pfname", peifang.getPfname())
            .eq("gongyi_types", peifang.getGongyiTypes())
            .eq("shifou_types", peifang.getShifouTypes())
            .eq("peifang_content", peifang.getPeifangContent())
            .eq("xiangqing_content", peifang.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeifangEntity peifangEntity = peifangService.selectOne(queryWrapper);
        if(peifangEntity==null){
            peifang.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      peifang.set
        //  }
            peifangService.insert(peifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeifangEntity peifang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,peifang:{}",this.getClass().getName(),peifang.toString());
        //根据字段查询是否有相同数据
        Wrapper<PeifangEntity> queryWrapper = new EntityWrapper<PeifangEntity>()
            .notIn("id",peifang.getId())
            .andNew()
            .eq("pfname", peifang.getPfname())
            .eq("gongyi_types", peifang.getGongyiTypes())
            .eq("shifou_types", peifang.getShifouTypes())
            .eq("peifang_content", peifang.getPeifangContent())
            .eq("xiangqing_content", peifang.getXiangqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeifangEntity peifangEntity = peifangService.selectOne(queryWrapper);
        if(peifangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      peifang.set
            //  }
            peifangService.updateById(peifang);//根据id更新
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
        peifangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

