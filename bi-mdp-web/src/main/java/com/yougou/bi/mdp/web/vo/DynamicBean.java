package com.yougou.bi.mdp.web.vo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

/**
 * 
 * @author li.l
 * @date 2014-11-19
 */

public class DynamicBean {

	/**
	 * 实体Object
	 */
	private Object object = null;

	/**
	 * 属性map
	 */
	private BeanMap beanMap = null;

	public DynamicBean() {
		super();
	}

	@SuppressWarnings({ "rawtypes" })
	public DynamicBean(Map propertyMap) {
		this.object = generateBean(propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}

	/**
	 * 给bean属性赋值
	 * 
	 * @param property
	 *            属性名
	 * @param value
	 *            值
	 */
	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	/**
	 * 通过属性名得到属性值
	 * 
	 * @param property
	 *            属性名
	 * @return 值
	 */
	public Object getValue(String property) {
		return beanMap.get(property);
	}

	/**
	 * 得到该实体bean对象
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}

	public BeanMap getBeanMap() {
		return beanMap;
	}

	public void setBeanMap(BeanMap beanMap) {
		this.beanMap = beanMap;
	}

	public void setObject(Object object) {
		this.object = object;
	}


	@SuppressWarnings("rawtypes")
	private Object generateBean(Map propertyMap) {
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for (Iterator i = keySet.iterator(); i.hasNext();) {
			String key = (String) i.next();
			generator.addProperty(key, (Class) propertyMap.get(key));
		}
		return generator.create();
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) throws ClassNotFoundException {
		long startTime=System.currentTimeMillis();   //获取开始时间
		Map propertyMap = new HashMap();
		for (int i = 0; i < 100000; i++) {

			for (int j = 1; j < 100; j++) {
				String strColumnName = "v" + j;
				propertyMap.put(strColumnName,
						Class.forName("java.lang.String"));
			}

			DynamicBean bean = new DynamicBean(propertyMap);
			for (int j = 1; j < 100; j++) {
				bean.setValue("v"+j, "100");
			}
			//System.out.println(bean.getBeanMap());
		}
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}
}