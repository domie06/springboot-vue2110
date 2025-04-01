package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 订单
 *
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("dingdan")
public class DingdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DingdanEntity() {

	}

	public DingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "ordernumber")
    private String ordernumber;


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
    @TableField(value = "goumai_time",fill = FieldFill.UPDATE)

    private Date goumaiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
    public String getOrdernumber() {
        return ordernumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setOrdernumber(String ordernumber) {
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

    @Override
    public String toString() {
        return "Dingdan{" +
            "id=" + id +
            ", ordernumber=" + ordernumber +
            ", huazhuangpinId=" + huazhuangpinId +
            ", yonghuId=" + yonghuId +
            ", number=" + number +
            ", expense=" + expense +
            ", maxexpense=" + maxexpense +
            ", goumaiTime=" + goumaiTime +
            ", createTime=" + createTime +
        "}";
    }
}
