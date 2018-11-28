package com.yougou.bi.mdp.common.constans;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 * 
 * @author li.l
 * @date 2014-9-15
 * @version 0.1.0
 * @copyright yougou.com
 * 
 */
public class PublicConstans {

	public static final String SESSION_USER = "session_user";
	public static final String SESSION_AREASYSTEMID = "31";
	public static final String SESSION_KEY_PREFIX = "session_key_prefix";

	public static final int AREA_SYSTEM_ID = 106; // BI系统ID
	public static final int MDM_SYSTEM_ID = 104; // MDM系统ID

	// 系统操作权限缓存
	public static final String SYSTEM_OPREATION_MAP = "system_opreation_map";

	public static final String IMPORT_EXCEL_KEY = "Filedata"; // 导入excel的form
																// key

	public static final String DOWNLOAD_DIR = "/resources/download"; // 导入excel的模板路径

	public static final String PICTURE_URL = "https://pic.belle.net.cn";

	public static final String ENCODE = "utf-8"; // utf-8

	public static final String PIC_SIZE = "104x104"; // utf-8

	
	//导入页面参数
	public static final String IMPORT_PARAMS = "importParams";
	public static final String IMPORT_TYPE = "importType";
	public static final String IMPORT_COVER = "cover";
	public static final String IMPORT_APPEND = "append";
	
	
	//返回参数
	public static final String FLAG_0 = "success";
	public static final String FLAG_1 = "fail";
	
	
	public static final String ERROR_KEY="error";

	/**
	 * 登录用户Cookie的ID值
	 */
	public static final String LOGIN_SYSTEM_USER_COOKIE_ID = "login_system_user_cookie_id_mdm";
	public static final int LOGIN_COOKIE_TIME = 7 * 24 * 60 * 60;

	public static final Byte FIEXD_DB = 1; // 固定报表连接的数据库 0：oracle, 1: pg

	/**
	 * DecimalFormat 数据格式常量
	 */
	public static String FORMAT_TWO_DIGTAL = "#0.00"; // 保留两位小数
	public static String FORMAT_INTTHOUSANDS = ",###"; // 整数千分位
	public static String FORMAT_GROWTHRATE = "#0.0%"; // 百分比 保留一位小数
	public static String FORMAT_PERCENTAGE = "#%"; // 百分比 保留整数

	/**
	 * 固定报表查询不到数据的提示
	 */
	public static String SELECE_NULL_DATA_ALERT = "没有查到数据，请更换查询条件";

	// REDIS配置
	public static final String redis_ip = "172.17.210.149";

	public static final int redis_port = 6379;

	// 拼装报表 常量定义
	public static final String schema = "U_MD_DM" + "."; // 数据库模式
	// public static final String fixed_schema = "U_MD_RS_DEV"; //数据库模式
	public static final String fixed_schema = "U_MD_RS"; // 数据库模式
	// public static final String emptyStr = "::VARCHAR,'//'";
	public static final String emptyStr = "||'','//'"; // oracle写法
	public static final String indexStr = "and"; // 截取字符串的开始位置

	/**
	 * 条件缓存忽略的Key
	 */
	public static final String[] NOT_CONDITION_PARAM = { "sales_property_m",
			"sales_property_c", "sales_property_tpye", "reportId", "userId",
			"type", "reportType", "schema", "fixed_schema", "costDegree" };

	// &符号分隔符
	public static final String separator = "!@";

	/**
	 * 友好提示语 - 提示语前缀
	 */
	public static final String friendly = "sorry";

	public static final String ADD = "1"; // 新增权限编码
	public static final String EDIT = "2"; // 编辑权限编码
	public static final String DELETE = "3";// 删除权限编码
	public static final String CONNECT = "23";// 关联生成权限编码
	public static final String CUSTOM_REPORT = "自定义报表";
	public static final String REPORT_CENTER = "模板中心";
	public static final String MEM_CUSTOM_REPORT = "会员自定义报表";
	public static final String MEM_REPORT_CENTER = "会员模板中心";

	public static final String IMPORT_PIC_KEY = "Filedata"; // 导入图片的form key

	public static final String IMPORT_INTERFACE = "导入接口";

	public static final String MemberKey = "会员BI";
	public static final String RetailKey = "零售BI";
	
	public static final String ORALCE = "ORACLE";
	
	public static final String GREENPLUM = "GREENPLUM";

	// [GP]数据源和实体机映射关系
	public final static Map<String, String> DATA_SOURCE_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("postgresqlDataSourceGP", "GREENPLUM-200");
			put("oracleDataSourceBI", "ORACLE-244");
			put("oracleDataSourceBI1", "ORACLE-239");
			put("oracleDataSourceBI2", "ORACLE-241");
			put("oracleDataSourceBI3", "ORACLE-242");
			put("GREENPLUM-200", "postgresqlDataSourceGP");
			put("ORACLE-244", "oracleDataSourceBI");
			put("ORACLE-239", "oracleDataSourceBI1");
			put("ORACLE-241", "oracleDataSourceBI2");
			put("ORACLE-242", "oracleDataSourceBI3");
		}
	};
}
