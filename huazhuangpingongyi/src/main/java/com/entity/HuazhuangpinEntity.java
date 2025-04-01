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
 * 化妆品
 *
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("huazhuangpin")
public class HuazhuangpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuazhuangpinEntity() {

	}

	public HuazhuangpinEntity(T t) {
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
     * 化妆品名称
     */
    @TableField(value = "kzpname")

    private String kzpname;


    /**
     * 品牌
     */
    @TableField(value = "pinpai_types")

    private Integer pinpaiTypes;


    /**
     * 类型
     */
    @TableField(value = "leixing_types")

    private Integer leixingTypes;


    /**
     * 工艺
     */
    @TableField(value = "gongyi_types")

    private Integer gongyiTypes;


    /**
     * 价格
     */
    @TableField(value = "expense")

    private Double expense;


    /**
     * 图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


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
	 * 设置：化妆品名称
	 */
    public String getKzpname() {
        return kzpname;
    }


    /**
	 * 获取：化妆品名称
	 */

    public void setKzpname(String kzpname) {
        this.kzpname = kzpname;
    }
    /**
	 * 设置：品牌
	 */
    public Integer getPinpaiTypes() {
        return pinpaiTypes;
    }


    /**
	 * 获取：品牌
	 */

    public void setPinpaiTypes(Integer pinpaiTypes) {
        this.pinpaiTypes = pinpaiTypes;
    }
    /**
	 * 设置：类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 设置：工艺
	 */
    public Integer getGongyiTypes() {
        return gongyiTypes;
    }


    /**
	 * 获取：工艺
	 */

    public void setGongyiTypes(Integer gongyiTypes) {
        this.gongyiTypes = gongyiTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 获取：价格
	 */

    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 设置：图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
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
        return "Huazhuangpin{" +
            "id=" + id +
            ", kzpname=" + kzpname +
            ", pinpaiTypes=" + pinpaiTypes +
            ", leixingTypes=" + leixingTypes +
            ", gongyiTypes=" + gongyiTypes +
            ", expense=" + expense +
            ", imgPhoto=" + imgPhoto +
            ", createTime=" + createTime +
        "}";
    }
}
