package com.yougou.bi.mdp.web.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import com.yougou.bi.mdp.common.constans.PublicConstans;

public class StringUtil {
	
	public static String replaceNullWithZero(Object obj){
		if(null == obj || obj.toString().isEmpty()){
			return "0";
		}
		return obj.toString();
	}
	
	public static boolean isEmpty(String obj){
		if(obj == null || obj.isEmpty()){
			return true;
		}
	    return false;
	}

	/**
	 * 方法名称:transMapToString 传入参数:map 返回值:String 形如
	 * username'chenziwen^password'1234
	 */
	@SuppressWarnings("rawtypes")
	public static String transMapToString(Map map) {
		if (map.isEmpty()) {
			return null;
		}
		java.util.Map.Entry entry;
		StringBuffer sb = new StringBuffer();
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			entry = (java.util.Map.Entry) iterator.next();
			if (null != entry.getValue() && !"".equals(entry.getValue())) {
				sb.append(entry.getKey().toString()).append("=")
						.append(entry.getValue().toString())
						.append(iterator.hasNext() ? "@@" : "");
			}
		}

		return sb.toString();
	}

	/**
	 * 方法名称:transStringToMap 传入参数:mapString 返回值:Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map transStringToMap(String mapString, String special) {
		Map map = new HashMap();
		String keyValue[] = mapString.split(special);
		for (String obj : keyValue) {
			if (obj.indexOf("=") > -1) {
				String value[] = obj.split("=");
				if (value.length == 2
						&& (value[1] != null && !"".equals(value[1]))) {
					map.put(value[0], value[1]);
				}
			}
		}
		return map;
	}

	public static String getStringNoBlank(String str) {
		if (str != null && !"".equals(str)) {
			Pattern p = Pattern.compile("\\s*|t|r|n");
			Matcher m = p.matcher(str);
			String strNoBlank = m.replaceAll("");
			return strNoBlank;
		} else {
			return str;
		}
	}

	// 回车换行多空格替换成单空格
	public static String getSingerSpace(String str) {
		return str.replace('\r', ' ').replace('\n', ' ')
				.replaceAll(" {2,}+", " ");
	}

	/**
	 * 字符串为空的,转换成长度为0的字符串
	 */

	public static String null2Blank(Object str) {
		return null2DefValue(str, "");
	}

	/**
	 * 如果对象为空,则用默认的值替换
	 */
	public static String null2DefValue(Object str, String defaultValue) {
		if (isNull(str) || "0".equals(str)) {
			return defaultValue;
		} else {
			return str.toString().trim();
		}
	}

	/**
	 * 如果对象为空,则用默认的值替换
	 */
	public static String null3DefValue(Object str, String defaultValue) {
		if (isNull(str)) {
			return defaultValue;
		} else {
			return str.toString().trim();
		}
	}

	/**
	 * 判断参数是否为空,如果为空返回true
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNull(Object obj) {
		if (obj == null || "null".equals(obj) || "NULL".equals(obj)
				|| PublicConstans.emptyStr.replace("\'", "").equals(obj)) {
			return true;
		}
		if (obj instanceof String) {
			return (obj.toString().trim().length() == 0);
		}
		return false;
	}

	public static int countToken(String str, String token) {
		int count = 0;
		while (str.indexOf(token) != -1) {
			count++;
			str = str.substring(str.indexOf(token) + token.length());
		}
		return count;
	}

	// 提取 括号里面的值
	public static String getInsideOfParentheses(String obj) {
		obj = obj.replace("\n", "");
		Pattern pattern = Pattern.compile("(?<=\\()(.+?)(?=\\))");
		Matcher matcher = pattern.matcher(obj);
		if (matcher.find()) {
			String objStr = matcher.group(1);
			return objStr;
		} else {
			return null;
		}
	}

	// 截取制定字符前的字符oldStr={订货单位类别and订货单位,订货单位名称and订货单位}
	public static String getSubStr(String beferColumnStr, String indexOfStr) {
		if (beferColumnStr == null) {
			return null;
		}
		if (beferColumnStr.endsWith(",")) {
			beferColumnStr = beferColumnStr.substring(0,
					beferColumnStr.length() - 1);
		}
		for (String dimensionStr : beferColumnStr.split(",")) {
			String newStr = dimensionStr.indexOf(indexOfStr) > -1 ? dimensionStr
					.substring(0, dimensionStr.indexOf(indexOfStr))
					: dimensionStr;
			beferColumnStr = beferColumnStr.replace(dimensionStr, newStr);
		}
		beferColumnStr = beferColumnStr.endsWith(",") ? beferColumnStr
				.substring(0, beferColumnStr.lastIndexOf(",")) : beferColumnStr;
		return beferColumnStr;
	}

	// 提取 括号里面的值
	public static List<String> getInsideOfParenthesesList(String obj) {
		List<String> result = new ArrayList<String>();
		obj = obj.replace("\n", "");
		Pattern pattern = Pattern.compile("(?<=\\()(.+?)(?=\\))");
		Matcher matcher = pattern.matcher(obj);
		while (matcher.find()) {
			String objStr = matcher.group(1);
			objStr = objStr.replace(PublicConstans.emptyStr, "");
			result.add(objStr);
		}
		return result;
	}

	// 匹配花括号
	public static List<String> matchParentheses(String obj) {
		List<String> matchList = new ArrayList<String>();
		if (obj.toUpperCase().indexOf("SUM(") > -1
				|| obj.toUpperCase().indexOf("0 AS ") > -1) { // 嵌套sql异常处理，以免浪费系统资源
			matchList.add("");
			return matchList;
		}
		String regex = "\\(([^()]+|\\(([^()]+)*\\))*\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(obj);
		while (matcher.find()) {
			matchList.add(matcher.group(0));
		}
		return matchList;
	}

	// 提取字符串中的英文单词
	public static List<String> getEnglishWords(String orgStr) {
		String regex = "[a-z&['']&A-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(orgStr);
		List<String> wordList = new ArrayList<String>();
		while (matcher.find()) {
			wordList.add(matcher.group());
		}
		return wordList;
	}

	// 提取字符串中的英文单词
	public static List<String> getConditionWords(Map<String, Object> params) {
		String[] list = { "DIM_ORG_STORE_ALLINFO.STORE_NAME",
				"DIM_PRO_ALLINFO.SORT_NAME", "DIM_PRO_ALLINFO.SERIES_NAME",
				"DIM_PRO_ALLINFO.STYLE_CATEGORY_NAME",
				"DIM_PRO_ALLINFO.REPEAT_LISTING_NAME",
				"DIM_PRO_ALLINFO.STYLE_NAME" };
		List<String> wordList = new ArrayList<String>();
		for (String e : list) {
			String value = params.get(e) == null ? null : String.valueOf(params
					.get(e));
			if (value != null) {
				wordList.add(value);
			}
		}
		return wordList;
	}

	// 下划线分割字符串取后串,如I-科技(ITECH)_I-科技(ITECH)-->I-科技(ITECH)
	public static List<String> getWords(String orgStr) {
		List<String> wordList = new ArrayList<String>();
		String regex = "[a-z&['']&A-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(orgStr);
		if (matcher.find()) {
			if (!orgStr.isEmpty()) {
				for (String obj : orgStr.split(",")) {
					for (String value : obj.split("_")) {
						wordList.add(value);
					}
				}
			}
		}
		return wordList;
	}

	// 判断是否全数字组成
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]*)?$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param a
	 *            被匹配的长字符串
	 * @param b
	 *            匹配的短字符串
	 * @return 匹配次数
	 */
	public static int count(String a, String b) {
		if (a.length() < b.length()) {
			return 0;
		}
		char[] a_t = a.toCharArray();
		char[] b_t = b.toCharArray();
		int count = 0, temp = 0, j = 0;

		for (int i = 0; i < a_t.length; i++) {
			// 保证一个连续的字符串 b 跟 a中某段相匹配
			if (a_t[i] == b_t[j] && j < b_t.length) {
				temp++;
				j++;
				// 此时连续的字符串 b 跟 已跟 a 中某段相匹配
				if (temp == b_t.length) {
					count++;
					temp = 0;
					j = 0;
				}
			}
			// 只要有一个字符不匹配，temp计数从来
			else {
				temp = 0;
				j = 0;
			}
		}

		return count;
	}

	// 对数字和字符混合且以数字结尾的字符串进行排序
	public static String sortNumStr(String containsNumStr) {
		List<String> strs = Arrays.asList(containsNumStr.split(","));
		Comparator<String> com = new Comparator<String>() {
			public int compare(String o1, String o2) {
				// 前面3个IF主要是判空的
				if (o1 == o2) {
					return 0;
				}
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return -1;
				}
				if (o1.equals(o2)) {
					return 0;
				}
				// 这里没有做太多的判断, index 代表第几个开始是数字, 直接从后面遍历
				// 比如 aa11, 我们就会判断从下标[2]开始为不是数字, 就直接截取 [2] 后面, 即11
				int index = 0;
				for (index = o1.length() - 1; index >= 0
						&& (o1.charAt(index) >= '0' && o1.charAt(index) <= '9'); index--)
					;
				int num1 = Integer.parseInt(o1.substring(index + 1));

				for (index = o2.length() - 1; index >= 0
						&& (o2.charAt(index) >= '0' && o2.charAt(index) <= '9'); index--)
					;
				int num2 = Integer.parseInt(o2.substring(index + 1));
				return num1 - num2;
			}
		};
		Collections.sort(strs, com);
		StringBuffer buffer = new StringBuffer();
		for (String obj : strs) {
			buffer.append(obj).append(",");
		}
		String newStr = buffer.toString();
		newStr = newStr.endsWith(",") ? newStr.substring(0,
				newStr.lastIndexOf(",")) : newStr;
		return newStr;
	}

	public static boolean isChineseCharacter(String str) {

		String regExp = "[\u4E00-\u9FA5]";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static String mapToString(Map<String, Object> params) {
		String sb = "";
		for (String key : params.keySet()) {
			sb = sb + (key + "=" + params.get(key) + "&");
		}
		return sb;
	}

	public static Map<String, Object> stringToMap(String params) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] p = params.split("&");
		for (String key_value : p) {
			if (key_value.trim().length() > 0) {
				int length = key_value.split("=").length;
				String k = key_value.split("=")[0];
				String v = "";
				if (length > 1) {
					v = key_value.split("=")[1];
				} else {
					v = "";
				}
				map.put(k, v);
			}
		}
		return map;
	}

	public static String generateShortUuid() {
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };

		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	public static String getUUID() {
		String uuid = generateShortUuid();
		while (isNumeric(uuid.substring(0, 1))) {
			uuid = generateShortUuid();
		}
		return uuid;
	}

	/**
	 * 对数字和字符混合的字符串进行排序
	 * 
	 * @param str
	 * @return
	 */
	public static String sortMixedStr(String str) {
		String arr[] = str.split(",");
		Arrays.sort(arr);
		String newStr = Arrays.toString(arr).replace("[", "").replace("]", "")
				.replace(" ", "");
		return newStr;
	}

	// 对数字和字符混合且以数字结尾的字符串进行排序
	public static String sortStr(String containsNumStr) {
		List<String> strs = Arrays.asList(containsNumStr.split(","));
		String newStr = "";
		if (strs.size() > 0 && !isCharStartAndNumEnd(strs.get(0))) { // 不是以字符开头,数字结尾
			String arr[] = containsNumStr.split(",");
			Arrays.sort(arr);
			newStr = Arrays.toString(arr).replace("[", "").replace("]", "")
					.replace(" ", "");
			return newStr;
		}
		Comparator<String> com = new Comparator<String>() {
			public int compare(String o1, String o2) {
				// 前面3个IF主要是判空的
				if (o1 == o2) {
					return 0;
				}
				if (o1 == null || o1.isEmpty()) {
					return 1;
				}
				if (o2 == null || o2.isEmpty()) {
					return -1;
				}
				if (o1.equals(o2)) {
					return 0;
				}
				// 这里没有做太多的判断, index 代表第几个开始是数字, 直接从后面遍历
				int index = 0;
				for (index = o1.length() - 1; index >= 0
						&& (o1.charAt(index) >= '0' && o1.charAt(index) <= '9'); index--)
					;
				long num1 = Long.parseLong(o1.substring(index + 1));

				for (index = o2.length() - 1; index >= 0
						&& (o2.charAt(index) >= '0' && o2.charAt(index) <= '9'); index--)
					;
				long num2 = Long.parseLong(o2.substring(index + 1));
				return (int) (num1 - num2);
			}
		};

		Collections.sort(strs, com);
		StringBuffer buffer = new StringBuffer();
		for (String obj : strs) {
			buffer.append(obj).append(",");
		}
		newStr = buffer.toString();
		newStr = newStr.endsWith(",") ? newStr.substring(0,
				newStr.lastIndexOf(",")) : newStr;
		return newStr;
	}

	// 判断字符串是否以字母开头,以数字结尾
	public static boolean isCharStartAndNumEnd(String str) {
		if (str == null)
			return false;
		if (str.equals(""))
			return false;
		Pattern p = Pattern.compile("^[a-zA-Z].*\\d+$");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	public static String repaceNullWithEmpty(String str) {
		return str == null ? "" : str;
	}

	public static List<String> getOutSideParenthesesStr(String str) {
		ArrayList<String> word = new ArrayList<String>();
		int m = 0, n = 0;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				if (count == 0) {
					m = i;
				}
				count++;
			}
			if (str.charAt(i) == ')') {
				count--;
				if (count == 0) {
					n = i;
					word.add(str.substring(m, n + 1));
				}
			}
		}
		return word;
	}

	public static List<String> getParenthesesStr(String str) {
		List<String> listStr = new ArrayList<String>();
		List<String> list = getOutSideParenthesesStr(str);
		for (String obj : list) {
			String tempStr = str.substring(0, str.indexOf(obj));
			if (tempStr.indexOf(",") > -1) {
				tempStr = str.substring(tempStr.lastIndexOf(",") + 1,
						str.indexOf(obj) + obj.length());
			} else {
				tempStr = str.substring(0, str.indexOf(obj) + obj.length());
			}
			listStr.add(tempStr);
			str = str.replace(tempStr, "");
		}
		return listStr;
	}

	public static String repaceNull(Object obj) {
		return obj == null ? "" : obj.toString();
	}
// 判段改年份是否为闰年(传入参数是个大于四位的时间字符串"20150101"||"201501"||"2015")
	public static boolean isLeapYear(String str) {
		if (str == null)
			return false;
		if (str.equals(""))
			return false;
		int year=Integer.parseInt(str.substring(0, 4)); 
		 if(((year%400==0))||((year%100!=0)&&(year%4==0))){
			 return true;
		 }
		return false;
	}
	
	public static String getStrWithoutBlank(String str) {
		return StringUtils.isBlank(str) ? "" : str.trim();
	}
}
