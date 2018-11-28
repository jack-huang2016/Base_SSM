package com.yougou.bi.mdp.common.exception;

/**
 * 业务异常
 * 
 * @ClassName: ParameterException
 * @author 黄耀杰
 * @date 2018-09-26 下午15:40:33
 */
public class BusinessException extends RuntimeException {

	private String code;
	private Object data;

	private BusinessException(String msg) {
		super(msg);
	}

	private BusinessException(String code, String msg) {
		super(msg);
		this.code = code;
	}

	public static BusinessException newInstance(BusinessExceptionEnum em) {
		BusinessException be = new BusinessException(em.getCode(), em.getMsg());
		return be;
	}

	public static BusinessException newInstance(BusinessExceptionEnum em,
			String msg) {
		BusinessException be = new BusinessException(em.getCode(), msg);
		return be;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static void main(String args[]) {
		BusinessExceptionEnum.SYS_UNNO.create();
		BusinessExceptionEnum.DB_NORMAL.create();
		BusinessExceptionEnum.BUS_NOLOGIN.create();
	}
}
