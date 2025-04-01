package com.entity.view;

import com.entity.HuazhuangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 化妆品
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("huazhuangpin")
public class HuazhuangpinView extends HuazhuangpinEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 品牌的值
		*/
		private String pinpaiValue;
		/**
		* 类型的值
		*/
		private String leixingValue;
		/**
		* 工艺的值
		*/
		private String gongyiValue;



	public HuazhuangpinView() {

	}

	public HuazhuangpinView(HuazhuangpinEntity huazhuangpinEntity) {
		try {
			BeanUtils.copyProperties(this, huazhuangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 品牌的值
			*/
			public String getPinpaiValue() {
				return pinpaiValue;
			}
			/**
			* 设置： 品牌的值
			*/
			public void setPinpaiValue(String pinpaiValue) {
				this.pinpaiValue = pinpaiValue;
			}
			/**
			* 获取： 类型的值
			*/
			public String getLeixingValue() {
				return leixingValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setLeixingValue(String leixingValue) {
				this.leixingValue = leixingValue;
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








}
