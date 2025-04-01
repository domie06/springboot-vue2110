package com.entity.model;

import com.entity.PeifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 配方
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-25
 */
public class PeifangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 化妆品配方名称
     */
    private String pfname;


    /**
     * 工艺
     */
    private Integer gongyiTypes;


    /**
     * 是否验收
     */
    private Integer shifouTypes;


    /**
     * 化妆品配方
     */
    private String peifangContent;


    /**
     * 化妆品详情
     */
    private String xiangqingContent;


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
	 * 获取：化妆品配方名称
	 */
    public String getPfname() {
        return pfname;
    }


    /**
	 * 设置：化妆品配方名称
	 */
    public void setPfname(String pfname) {
        this.pfname = pfname;
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
	 * 获取：是否验收
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 设置：是否验收
	 */
    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 获取：化妆品配方
	 */
    public String getPeifangContent() {
        return peifangContent;
    }


    /**
	 * 设置：化妆品配方
	 */
    public void setPeifangContent(String peifangContent) {
        this.peifangContent = peifangContent;
    }
    /**
	 * 获取：化妆品详情
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 设置：化妆品详情
	 */
    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
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
