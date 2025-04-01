package com.entity.model;

import com.entity.DingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-25
 */
public class DingdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private Integer ordernumber;


    /**
     * 购买化妆品
     */
    private Integer huazhuangpinId;


    /**
     * 购买人
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer number;


    /**
     * 单价
     */
    private Double expense;


    /**
     * 总价
     */
    private Double maxexpense;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date goumaiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public Integer getOrdernumber() {
        return ordernumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }
    /**
	 * 获取：购买化妆品
	 */
    public Integer getHuazhuangpinId() {
        return huazhuangpinId;
    }


    /**
	 * 设置：购买化妆品
	 */
    public void setHuazhuangpinId(Integer huazhuangpinId) {
        this.huazhuangpinId = huazhuangpinId;
    }
    /**
	 * 获取：购买人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：购买人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 设置：购买数量
	 */
    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
	 * 获取：单价
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 设置：单价
	 */
    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 获取：总价
	 */
    public Double getMaxexpense() {
        return maxexpense;
    }


    /**
	 * 设置：总价
	 */
    public void setMaxexpense(Double maxexpense) {
        this.maxexpense = maxexpense;
    }
    /**
	 * 获取：购买时间
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 设置：购买时间
	 */
    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
