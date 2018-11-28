package com.yougou.bi.mdp.common.result;

import com.yougou.bi.mdp.common.exception.BusinessException;

/**
 * @author 孔卫佳
 * @since 2014
 */
public class ResultUtil {
	public static Result success() {
		Result rt = new Result();
		rt.setRet(Result.SUCCESS);
		return rt;
	}

	public static Result success(Object data) {
		Result rt = success();
		rt.setData(data);
		return rt;
	}

	public static Result fail() {
		Result rt = new Result();
		rt.setRet(Result.FAIL);
		return rt;
	}

	public static Result fail(BusinessException e) {
		Result rt = fail();
		rt.setErrCode(e.getCode());
		rt.setErrMsg(e.getMessage());
		rt.setData(e.getData());
		return rt;
	}

	public static Result fail(String errMsg) {
		Result rt = fail();
		rt.setErrMsg(errMsg);
		return rt;
	}

	public static Result fail(String errMsg, String errCode) {
		Result rt = fail();
		rt.setErrMsg(errMsg);
		rt.setErrCode(errCode);
		return rt;
	}

	public static Result fail(String errCode, String errMsg, Object data) {
		Result rt = fail();
		rt.setErrMsg(errMsg);
		rt.setErrCode(errCode);
		rt.setData(data);
		return rt;
	}
}
