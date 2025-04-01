package com.entity.view;

import com.entity.PeifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 配方
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("peifang")
public class PeifangView extends PeifangEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 工艺的值
		*/
		private String gongyiValue;
		/**
		* 是否验收的值
		*/
		private String shifouValue;



	public PeifangView() {

	}

	public PeifangView(PeifangEntity peifangEntity) {
		try {
			BeanUtils.copyProperties(this, peifangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 工艺的值
			*/
			public String getGongyiValue() {
				return gongyiValue;
			}
			/**
			* 设置： 工艺的值
			*/
			public void setGongyiValue(String gongyiValue) {
				this.gongyiValue = gongyiValue;
			}
			/**
			* 获取： 是否验收的值
			*/
			public String getShifouValue() {
				return shifouValue;
			}
			/**
			* 设置： 是否验收的值
			*/
			public void setShifouValue(String shifouValue) {
				this.shifouValue = shifouValue;
			}








}
