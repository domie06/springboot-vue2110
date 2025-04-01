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

import com.entity.DingdanEntity;

import com.service.DingdanService;
import com.entity.view.DingdanView;
import com.service.HuazhuangpinService;
import com.entity.HuazhuangpinEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 订单
 * 后端接口
 * @author
 * @email
 * @date 2021-03-25
*/
@RestController
@Controller
@RequestMapping("/dingdan")
public class DingdanController {
    private static final Logger logger = LoggerFactory.getLogger(DingdanController.class);

    @Autowired
    private DingdanService dingdanService;


    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private HuazhuangpinService huazhuangpinService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = dingdanService.queryPage(params);

        //字典表数据转换
        List<DingdanView> list =(List<DingdanView>)page.getList();
        for(DingdanView c:list){
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
        DingdanEntity dingdan = dingdanService.selectById(id);
        if(dingdan !=null){
            //entity转view
            DingdanView view = new DingdanView();
            BeanUtils.copyProperties( dingdan , view );//把实体数据重构到view中

            //级联表
            HuazhuangpinEntity huazhuangpin = huazhuangpinService.selectById(dingdan.getHuazhuangpinId());
            if(huazhuangpin != null){
                BeanUtils.copyProperties( huazhuangpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setHuazhuangpinId(huazhuangpin.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(dingdan.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody DingdanEntity dingdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dingdan:{}",this.getClass().getName(),dingdan.toString());
        Wrapper<DingdanEntity> queryWrapper = new EntityWrapper<DingdanEntity>()
            .eq("ordernumber", dingdan.getOrdernumber())
            .eq("huazhuangpin_id", dingdan.getHuazhuangpinId())
            .eq("yonghu_id", dingdan.getYonghuId())
            .eq("number", dingdan.getNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DingdanEntity dingdanEntity = dingdanService.selectOne(queryWrapper);
        if(dingdanEntity==null){
            dingdan.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      dingdan.set
        //  }
            dingdanService.insert(dingdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DingdanEntity dingdan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dingdan:{}",this.getClass().getName(),dingdan.toString());
        //根据字段查询是否有相同数据
        Wrapper<DingdanEntity> queryWrapper = new EntityWrapper<DingdanEntity>()
            .notIn("id",dingdan.getId())
            .andNew()
            .eq("ordernumber", dingdan.getOrdernumber())
            .eq("huazhuangpin_id", dingdan.getHuazhuangpinId())
            .eq("yonghu_id", dingdan.getYonghuId())
            .eq("number", dingdan.getNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DingdanEntity dingdanEntity = dingdanService.selectOne(queryWrapper);
                dingdan.setGoumaiTime(new Date());
        if(dingdanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      dingdan.set
            //  }
            dingdanService.updateById(dingdan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/purchase")
    public R purchase(@RequestBody Map<String, Object> params, HttpServletRequest request){
        if(params.size() == 0){
            return R.error("请选择要购买的化妆品");
        }
        //获取系统当前时间的时间戳作为订单号
        long danhao = new Date().getTime();
        Date date = new Date();
        for (String id: params.keySet()) {
            Integer zhi = Integer.parseInt(String.valueOf(params.get(id)));
            HuazhuangpinEntity huazhuangpin = huazhuangpinService.selectById(id);
            if(huazhuangpin == null){
                return R.error();
            }
            DingdanEntity dingdan = new DingdanEntity();
            dingdan.setCreateTime(date);
            dingdan.setGoumaiTime(date);
            dingdan.setExpense(huazhuangpin.getExpense());
            dingdan.setHuazhuangpinId(huazhuangpin.getId());
            dingdan.setNumber(zhi);
            dingdan.setMaxexpense(zhi*huazhuangpin.getExpense());
            dingdan.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            dingdan.setOrdernumber(String.valueOf(danhao));
            dingdanService.insert(dingdan);
        }
        return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        dingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

