package com.entity.vo;

import com.entity.DingdanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("dingdan")
public class DingdanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "ordernumber")
    private Integer ordernumber;


    /**
     * 购买化妆品
     */

    @TableField(value = "huazhuangpin_id")
    private Integer huazhuangpinId;


    /**
     * 购买人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "number")
    private Integer number;


    /**
     * 单价
     */

    @TableField(value = "expense")
    private Double expense;


    /**
     * 总价
     */

    @TableField(value = "maxexpense")
    private Double maxexpense;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "goumai_time")
    private Date goumaiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public Integer getOrdernumber() {
        return ordernumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }
    /**
	 * 设置：购买化妆品
	 */
    public Integer getHuazhuangpinId() {
        return huazhuangpinId;
    }


    /**
	 * 获取：购买化妆品
	 */

    public void setHuazhuangpinId(Integer huazhuangpinId) {
        this.huazhuangpinId = huazhuangpinId;
    }
    /**
	 * 设置：购买人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：购买人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 获取：购买数量
	 */

    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
	 * 设置：单价
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 获取：单价
	 */

    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 设置：总价
	 */
    public Double getMaxexpense() {
        return maxexpense;
    }


    /**
	 * 获取：总价
	 */

    public void setMaxexpense(Double maxexpense) {
        this.maxexpense = maxexpense;
    }
    /**
	 * 设置：购买时间
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 获取：购买时间
	 */

    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
