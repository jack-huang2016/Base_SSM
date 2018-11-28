package com.yougou.bi.mdp.web.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.yougou.bi.mdp.common.constans.PublicConstans;
import com.yougou.bi.mdp.common.utils.CommonUtil;
import com.yougou.bi.mdp.web.security.Authorization;
import com.yougou.logistics.base.common.model.SystemUser;

/**
 * @存放当前用户信息
 * @author wei.hj
 * @Date 2013-7-29
 * @version 0.1.0
 * @copyright yougou.com
 */
public class CurrentUser {

	private Integer userId; //用户ID
	private String username; // 中文姓名  管理员
	private String loginName; // 登陆名称  admin 
	private String organNo;   //机构编号
	private String organName;//机构名称


	public CurrentUser() {
		super();
	}


	public CurrentUser(HttpServletRequest request) {		 
		SystemUser user = Authorization.get().getUser();
		this.setUsername(user.getUsername());
		this.setLoginName(user.getLoginName());
		this.setOrganNo(user.getOrganNo());
		this.setOrganName(user.getOrganName());
		this.setUserId(user.getUserid());
	}

	/**
	 * 1.获取当前登录用户
	 * @param request
	 * @return
	 */
	public static SystemUser getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SystemUser user = (SystemUser) session.getAttribute(PublicConstans.SESSION_USER);

		return user;
	}

	/**
	 * 2.获取当前登录用户的菜单权限列表
	 * @param request
	 * @return
	 */

	/**
	 * 3.获取当前登录用户的数据权限列表
	 * @param request
	 * @return
	 */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCurrentDate10Str() {
		return CommonUtil.getCurrentDateTime();
	}

	public String getOrganNo() {
		return organNo;
	}

	public void setOrganNo(String organNo) {
		this.organNo = organNo;
	}
	
	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
