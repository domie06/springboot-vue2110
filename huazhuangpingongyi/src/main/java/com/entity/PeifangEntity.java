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
 * 配方
 *
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("peifang")
public class PeifangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeifangEntity() {

	}

	public PeifangEntity(T t) {
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
     * 化妆品配方名称
     */
    @TableField(value = "pfname")

    private String pfname;


    /**
     * 工艺
     */
    @TableField(value = "gongyi_types")

    private Integer gongyiTypes;


    /**
     * 是否验收
     */
    @TableField(value = "shifou_types")

    private Integer shifouTypes;


    /**
     * 化妆品配方
     */
    @TableField(value = "peifang_content")

    private String peifangContent;


    /**
     * 化妆品详情
     */
    @TableField(value = "xiangqing_content")

    private String xiangqingContent;


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
	 * 设置：化妆品配方名称
	 */
    public String getPfname() {
        return pfname;
    }


    /**
	 * 获取：化妆品配方名称
	 */

    public void setPfname(String pfname) {
        this.pfname = pfname;
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
	 * 设置：是否验收
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 获取：是否验收
	 */

    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 设置：化妆品配方
	 */
    public String getPeifangContent() {
        return peifangContent;
    }


    /**
	 * 获取：化妆品配方
	 */

    public void setPeifangContent(String peifangContent) {
        this.peifangContent = peifangContent;
    }
    /**
	 * 设置：化妆品详情
	 */
    public String getXiangqingContent() {
        return xiangqingContent;
    }


    /**
	 * 获取：化妆品详情
	 */

    public void setXiangqingContent(String xiangqingContent) {
        this.xiangqingContent = xiangqingContent;
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
        return "Peifang{" +
            "id=" + id +
            ", pfname=" + pfname +
            ", gongyiTypes=" + gongyiTypes +
            ", shifouTypes=" + shifouTypes +
            ", peifangContent=" + peifangContent +
            ", xiangqingContent=" + xiangqingContent +
            ", createTime=" + createTime +
        "}";
    }
}
