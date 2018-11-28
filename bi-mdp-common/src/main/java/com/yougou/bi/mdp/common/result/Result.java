package com.yougou.bi.mdp.common.result;

import java.io.IOException;
import java.io.Serializable;

import com.yougou.drp.common.utils.JsonUtils;

public class Result implements Serializable {

	private static final long serialVersionUID = -5330312791527026983L;
	
	public static final String SUCCESS = "1";
	public static final String FAIL = "0";
	
	private String ret;
	private String errMsg;
	private String errCode;
	private Object data;

	public Result() {
		super();
	}
	public Result(String ret, String errMsg, String errCode, Object data) {
		super();
		this.ret = ret;
		this.errMsg = errMsg;
		this.errCode = errCode;
		this.data = data;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toString() {
		String jsonStr = "";
		try {
			jsonStr = JsonUtils.toJson(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
}
