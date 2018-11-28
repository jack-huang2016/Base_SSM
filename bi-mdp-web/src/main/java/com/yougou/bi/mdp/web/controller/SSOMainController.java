package com.yougou.bi.mdp.web.controller;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yougou.logistics.base.common.annotation.IgnoredInterceptors;

/**
 * TODO: 增加描述
 * 
 * @author huang.yj
 * @date 2018-9-27 下午14:54:23
 * @version 0.1.0
 * @copyright yougou.com
 */
@Controller
public class SSOMainController {

	protected static final XLogger logger = XLoggerFactory
			.getXLogger(SSOMainController.class);

	
	@RequestMapping(value = "/index")
	@IgnoredInterceptors
	public String index() {
		return "/index";
	}
}
