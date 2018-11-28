package com.yougou.bi.mdp.web.utils;

import java.io.Serializable;

/**
 * TODO: 此类是Options的属性，Options又是editor的属性，是为了横排录入的商品是必填的
 * 
 * @author song.x
 * @date 2014-7-30 下午3:36:05
 * @version 0.1.0 
 * @copyright yougou.com 
 */
public class Validatebox  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3742365374949879208L;

	public Validatebox(){
		
	}
	
	public Validatebox(Options opt){
		this.options = opt;
	}
	
	private Options options;

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}
	
	

}
