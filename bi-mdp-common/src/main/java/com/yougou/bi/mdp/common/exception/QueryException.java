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
public class QueryException extends Exception {

	private static final long serialVersionUID = 1976634228193570675L;

	private int errorCode;

	public QueryException() {
	}

	public QueryException(String msg) {
		super(msg);
	}

	public QueryException(Throwable cause) {
		super(cause);
	}

	public QueryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public QueryException(int code, String msg) {
		super(msg);
		this.errorCode = code;
	}

	public QueryException(int code, String msg, Throwable cause) {
		super(code + ":" + msg, cause);
		this.errorCode = code;
	}

	public int getErrorCode() {
		return this.errorCode;
	}
}
