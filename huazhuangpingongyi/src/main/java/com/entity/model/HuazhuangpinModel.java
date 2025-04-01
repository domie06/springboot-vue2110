package com.entity.model;

import com.entity.HuazhuangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 化妆品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-25
 */
public class HuazhuangpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 化妆品名称
     */
    private String kzpname;


    /**
     * 品牌
     */
    private Integer pinpaiTypes;


    /**
     * 类型
     */
    private Integer leixingTypes;


    /**
     * 工艺
     */
    private Integer gongyiTypes;


    /**
     * 价格
     */
    private Double expense;


    /**
     * 图片
     */
    private String imgPhoto;


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
	 * 获取：化妆品名称
	 */
    public String getKzpname() {
        return kzpname;
    }


    /**
	 * 设置：化妆品名称
	 */
    public void setKzpname(String kzpname) {
        this.kzpname = kzpname;
    }
    /**
	 * 获取：品牌
	 */
    public Integer getPinpaiTypes() {
        return pinpaiTypes;
    }


    /**
	 * 设置：品牌
	 */
    public void setPinpaiTypes(Integer pinpaiTypes) {
        this.pinpaiTypes = pinpaiTypes;
    }
    /**
	 * 获取：类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 获取：工艺
	 */
    public Integer getGongyiTypes() {
        return gongyiTypes;
    }


    /**
	 * 设置：工艺
	 */
    public void setGongyiTypes(Integer gongyiTypes) {
        this.gongyiTypes = gongyiTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 设置：价格
	 */
    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 获取：图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
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
