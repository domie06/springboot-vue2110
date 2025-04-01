package com.entity.view;

import com.entity.DingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-25
 */
@TableName("dingdan")
public class DingdanView extends DingdanEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 huazhuangpin
			/**
			* 化妆品名称
			*/
			private String kzpname;
			/**
			* 品牌
			*/
			private Integer pinpaiTypes;
				/**
				* 品牌的值
				*/
				private String pinpaiValue;
			/**
			* 类型
			*/
			private Integer leixingTypes;
				/**
				* 类型的值
				*/
				private String leixingValue;
			/**
			* 工艺
			*/
			private Integer gongyiTypes;
				/**
				* 工艺的值
				*/
				private String gongyiValue;
			/**
			* 价格
			*/
			private Double expense;
			/**
			* 图片
			*/
			private String imgPhoto;

		//级联表 yonghu
			/**
			* 名称
			*/
			private String name;
			/**
			* 账号
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证
			*/
			private String idNumber;
			/**
			* 身份
			*/
			private String role;

	public DingdanView() {

	}

	public DingdanView(DingdanEntity dingdanEntity) {
		try {
			BeanUtils.copyProperties(this, dingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set huazhuangpin
					/**
					* 获取： 化妆品名称
					*/
					public String getKzpname() {
						return kzpname;
					}
					/**
					* 设置： 化妆品名称
					*/
					public void setKzpname(String kzpname) {
						this.kzpname = kzpname;
					}
					/**
					* 获取： 品牌
					*/
					public Integer getPinpaiTypes() {
						return pinpaiTypes;
					}
					/**
					* 设置： 品牌
					*/
					public void setPinpaiTypes(Integer pinpaiTypes) {
						this.pinpaiTypes = pinpaiTypes;
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
					* 获取： 类型
					*/
					public Integer getLeixingTypes() {
						return leixingTypes;
					}
					/**
					* 设置： 类型
					*/
					public void setLeixingTypes(Integer leixingTypes) {
						this.leixingTypes = leixingTypes;
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
					* 获取： 工艺
					*/
					public Integer getGongyiTypes() {
						return gongyiTypes;
					}
					/**
					* 设置： 工艺
					*/
					public void setGongyiTypes(Integer gongyiTypes) {
						this.gongyiTypes = gongyiTypes;
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
					* 获取： 价格
					*/
					public Double getExpense() {
						return expense;
					}
					/**
					* 设置： 价格
					*/
					public void setExpense(Double expense) {
						this.expense = expense;
					}
					/**
					* 获取： 图片
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 图片
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}







				//级联表的get和set yonghu
					/**
					* 获取： 名称
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 名称
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 账号
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账号
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 身份
					*/
					public String getRole() {
						return role;
					}
					/**
					* 设置： 身份
					*/
					public void setRole(String role) {
						this.role = role;
					}



}
