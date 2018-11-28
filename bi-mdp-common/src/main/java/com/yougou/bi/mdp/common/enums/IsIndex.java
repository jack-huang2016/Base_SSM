package com.yougou.bi.mdp.common.enums;

public enum IsIndex {

	维度在指标上方(1), 维度在指标下方(2), 维度并列显示(3);

	// 定义私有变量
	private int isIndex;

	// 构造函数，枚举类型只能为私有
	IsIndex(int isIndex) {

		this.isIndex = isIndex;
	}
	
	

	public int getIsIndex() {
		return isIndex;
	}


}
