package com.yougou.bi.mdp.common.exception;

/**
 * 数据源切换异常
 * 
 * @class
 * @extends Developer
 * @author liu.zx
 * @date 2017-01-22
 * @copyright wonhigh.cn
 */
public class DataSourceSwitchException extends Exception {

	private int errorCode;

	public DataSourceSwitchException() {
	}

	public DataSourceSwitchException(String msg) {
		super(msg);
	}

	public DataSourceSwitchException(Throwable cause) {
		super(cause);
	}

	public DataSourceSwitchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DataSourceSwitchException(int code, String msg) {
		super(msg);
		this.errorCode = code;
	}

	public DataSourceSwitchException(int code, String msg, Throwable cause) {
		super(code + ":" + msg, cause);
		this.errorCode = code;
	}

	public int getErrorCode() {
		return this.errorCode;
	}
}
