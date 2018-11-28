package com.yougou.bi.mdp.common.exception;

/**
 * 所有的异常类都要在这个地方管控到.
 * 
 * @author 黄耀杰
 * 
 */
public enum BusinessExceptionEnum {
	/**
	 * 系统错误 00
	 */
	SYS_UNNO("00-0000", "系统出错"),
	SYS_READXLSERROR("00-0001", "读取excel出错"),
	SYS_WRITXLSERROR("00-0002", "写入excel出错"),
	SYS_READREDISNULL("00-0003", "从redis中读取数据为空"),
	
	/**
	 * 数据库错误 10
	 */
	DB_NORMAL("10-0000", "数据库链接失败"),
	
	/**
	 * 业务错误20
	 */
	BUS_NOLOGIN("20-0000", "用户未登陆"),
	BUS_DATAERROR("20-0001", "数据异常"),
	BUS_PARAMEXCEPTION("20-0002", "参数异常"),
	BUS_MAKEDATAERROR("20-0003", "数据整理错误"),
	BUS_MAXCOLUMN2("20-9996", "超出Excel最大列,请缩小自定义分类1"),
	BUS_MAXCOLUMN("20-9997", "超出Excel最大列,请缩小查询范围"),
	BUS_MAXDATA("20-9998", "查询数据过多,请缩小查询范围"),
	BUS_NODATA("20-9999", "未查询到数据"),
	BUS_MAXDATA_FORGB040S("20-9998-1", "查询数据过多,请缩小查询范围（尝试管理城市单选）"),
	
	/**
	 * 拼接报表异常
	 */
	BUS_COLUMN_MAX("30-0001","最大列数超过1000。"),
	BUS_CREATEXCEL_ERROR("30-0002","生成excel失败。"),
	BUS_QUERY_FAIL("30-0003","查询失败。"),
	BUS_INSERT_FAIL("30-0004","导出失败。");
	
	
	
	
	// 错误代码
	private String code;
	// 通用提示,若需要特殊提示可以在创建BusinessException覆盖
	private String msg;

	// 私有化构造方法
	private BusinessExceptionEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	// 通过枚举建立一个BusinessException
	public BusinessException create() {
		return BusinessException.newInstance(this);
	}
	
	// 通过枚举建立一个BusinessException
	public BusinessException create(Exception e) {
		if (e instanceof BusinessException) {
			return (BusinessException)e;
		}
		return BusinessException.newInstance(this);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
