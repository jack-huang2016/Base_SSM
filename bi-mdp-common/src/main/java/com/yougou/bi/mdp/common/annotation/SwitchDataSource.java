package com.yougou.bi.mdp.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 多数据源切换
 * 
 * @author li.l
 * @date 2015-4-23 下午5:46:59
 * @version 0.1.0
 * @copyright yougou.com
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchDataSource {
	/**
	 * 数据源名称
	 * 
	 * @return
	 */
	String value() default "default";
}
