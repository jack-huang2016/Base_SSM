package com.yougou.bi.mdp.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import com.yougou.bi.mdp.common.constans.PublicConstans;
import com.yougou.bi.mdp.common.enums.IsIndex;
import com.yougou.bi.mdp.common.model.UDbPtReport;
import com.yougou.bi.mdp.web.vo.DynamicBean;

public class DynamicTabTheadUtil {

	protected static final XLogger logger = XLoggerFactory.getXLogger(DynamicTabTheadUtil.class);
	
	private static String columnSeparator = "##";
	
	private static int width = 120;
	
	//private static String totalDesc = "总计";
	

	/**
	 * 动态生成表头
	 * @param list
	 * @param beferColumnStr 左边维度列数
	 * @return
	 */

	public static LinkedList<LinkedList<JqueryDataGrid>> makeJqueryDataGrid(
			List<Map<String, List<Object>>> list, String beferColumnStr, UDbPtReport uDbPtReport, int indexNumber,
			String dimensionStr) {

		LinkedList<LinkedList<JqueryDataGrid>> returnColumnList = new LinkedList<LinkedList<JqueryDataGrid>>();

		if (list == null || list.size() == 0) {

			return returnColumnList;
		}
		
		if(uDbPtReport.getReportReverse().intValue() == 1){
			
			if (uDbPtReport.getDrillType().intValue() == IsIndex.维度并列显示.getIsIndex()) {

				 returnColumnList = constructIndexStand(list, beferColumnStr,uDbPtReport, indexNumber);
				 
			}else{
				 if(uDbPtReport.getDrillType().intValue() == IsIndex.维度在指标下方.getIsIndex()){
					 beferColumnStr = " ,"+beferColumnStr;
				 }else{
					 beferColumnStr = beferColumnStr+", ";
				 }
				 returnColumnList = constructIndexUp(list, beferColumnStr,uDbPtReport, indexNumber);
			}
			
		}else if (uDbPtReport.getDrillType().intValue() == IsIndex.维度在指标下方.getIsIndex()) {
			//尺码特性处理
			if(dimensionStr.contains("DIM_PRO_ALLINFO.SIZE_TYPE_CODE")){
				returnColumnList = constructSCIndexDown(list, beferColumnStr,uDbPtReport, indexNumber);
			}else{
				returnColumnList = constructIndexDown(list, beferColumnStr,uDbPtReport, indexNumber);
			}
		} else if (uDbPtReport.getDrillType().intValue() == IsIndex.维度在指标上方.getIsIndex()) {

			returnColumnList = constructIndexUp(list, beferColumnStr,uDbPtReport, indexNumber);

		} else if (uDbPtReport.getDrillType().intValue() == IsIndex.维度并列显示.getIsIndex()) {

			returnColumnList = constructIndexStand(list, beferColumnStr,uDbPtReport, indexNumber);
		}

		return returnColumnList;
	}

	
		/**
		 * 维度在指标下方,专门用于处理尺码维度
		 * 
		 * @author liuzx
		 * @param list
		 * @param beferColumnStr
		 *        左边维度列数
		 * @return
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static LinkedList<LinkedList<JqueryDataGrid>> constructSCIndexDown(
				List<Map<String, List<Object>>> list, String beferColumnStr, UDbPtReport uDbPtReport, int indexNumber) {
			String[] columnnStr = beferColumnStr.split(",");

			int beferColumn = columnnStr.length;

			LinkedList<LinkedList<JqueryDataGrid>> returnColumnList = new LinkedList<LinkedList<JqueryDataGrid>>();
			
			String dimensionRCount = uDbPtReport.getReportDimensionRCount();
			boolean haveRCount = false;
			//[尺码行合计]如果行总计字段不为空，则模板包含总计
			if(null != dimensionRCount && !dimensionRCount.isEmpty()){
				haveRCount = true;
			}
			
			int maxWidthScNum = 0;  //最大尺码组的尺码数
			int maxHighScNum  = 0;  //报表的尺码组数
			int indexNum = 0;       //指标数
			
			//计算最大尺码组的尺码数和报表的尺码组数
			String keyList = "";
			Object parentObj = list.get(0);
			LinkedMap parentMap = (LinkedMap) parentObj;
			Iterator<?> parentIt = parentMap.entrySet().iterator();
			
			while (parentIt.hasNext()) {
			    Map.Entry entry= (Entry) parentIt.next();  
				List<String> subList = (List<String>) entry.getValue();
				if(subList.size() > maxWidthScNum){
					maxWidthScNum = subList.size();
				}
				maxHighScNum ++;
			}
			
			maxWidthScNum = maxWidthScNum + 1;
			
			//计算指标的数量
			LinkedMap subsubsubObj = (LinkedMap)list.get(list.size() - 1);
			LinkedMap subsubsubMap = (LinkedMap) subsubsubObj;
			Iterator<?> subsubsubIt = subsubsubMap.entrySet().iterator();
			while (subsubsubIt.hasNext()) {
				Map.Entry entry= (Entry) subsubsubIt.next();  
				List<String> subList = (List) entry.getValue();
				indexNum = subList.size();
				break;
			}
			
			// 构造指标在上的第一行表头
			if (subsubsubObj instanceof LinkedMap) {
				
				LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();

				// 拼装纵向维度列数表头start
				for (int j = 0; j < beferColumn; j++) {
					JqueryDataGrid sizeColumn = new JqueryDataGrid();
					sizeColumn.setTitle(columnnStr[j]);
					sizeColumn.setAlign("center");
					sizeColumn.setRowspan(list.size() + maxHighScNum - 1);
					sizeColumn.setField("v" + j);
					columnList.add(sizeColumn);
				}
				
				// 拼装纵向维度列数表头end
				subsubsubMap = (LinkedMap) subsubsubObj;
				subsubsubIt = subsubsubMap.entrySet().iterator();
				while (subsubsubIt.hasNext()) {
					Map.Entry entry= (Entry) subsubsubIt.next();  
					String key = (String) entry.getKey();
					List<String> subList = (List) entry.getValue();
					for (String str : subList) {
						keyList += key + columnSeparator + str + ",";
					}
					break;
				}
				while (keyList.endsWith(",")) {
					keyList = keyList.substring(0, keyList.length() - 1);
				}
				
				for (String key : keyList.split(",")) {
					JqueryDataGrid sizeColumn = new JqueryDataGrid();
					String keyStr = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
					sizeColumn.setTitle(keyStr);
					sizeColumn.setAlign("center");
					sizeColumn.setColspan(maxWidthScNum);
					columnList.add(sizeColumn);
				}
				
				//[尺码行总计]
				if(haveRCount){
					int fieldNo = beferColumn + maxWidthScNum;
					JqueryDataGrid sizeColumn = new JqueryDataGrid();
					sizeColumn.setTitle("总计");
					sizeColumn.setRowspan(maxHighScNum + 1);
					sizeColumn.setColspan(1);
					sizeColumn.setWidth(width);
					sizeColumn.setField("v"+fieldNo);
					columnList.add(sizeColumn);
				}
				
				returnColumnList.add(columnList);
			}
			
			// 拼装维度开始
			parentMap = (LinkedMap) parentObj;
			parentIt = parentMap.entrySet().iterator();
			int sizeCodeSeq = 0;
			while (parentIt.hasNext()) {
				Map.Entry entry= (Entry) parentIt.next();  
				String key = (String) entry.getKey();
				LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();
				JqueryDataGrid sizeColumn = null;
				//循环拼装每一个指标的维度
				int k = beferColumn;
				for(int i = 0;i < indexNum ; i++){
					List<String> subList = (List) parentMap.get(key);
					
					//拼装尺码组
					sizeColumn = new JqueryDataGrid();
					sizeColumn.setTitle(key);
					sizeColumn.setAlign("center");
					sizeColumn.setColspan(1);
					sizeColumn.setWidth(width);
					if(sizeCodeSeq == 0){
						sizeColumn.setField("v" + k);
					}
					columnList.add(sizeColumn);
					k ++ ;
					
					//拼装尺码组的每一尺码
					for (String str : subList) {
						sizeColumn = new JqueryDataGrid();
						sizeColumn.setTitle(str);
						sizeColumn.setAlign("center");
						sizeColumn.setColspan(1);
						sizeColumn.setWidth(width);
						if(sizeCodeSeq == 0){
							sizeColumn.setField("v" + k);
						}
						columnList.add(sizeColumn);
						k ++ ;
					}
					
					//如果尺码组中的尺码达不到maxWidthScNum，则自动填充空值
					while(k < maxWidthScNum * (i+1) + beferColumn){
							
							sizeColumn = new JqueryDataGrid();
							sizeColumn.setTitle("");
							sizeColumn.setAlign("center");
							sizeColumn.setColspan(1);
							sizeColumn.setWidth(width);
							if(sizeCodeSeq == 0){
							sizeColumn.setField("v" + k);
							}
							columnList.add(sizeColumn);
							k++;
					}
				}
				sizeCodeSeq ++ ;
				returnColumnList.add(columnList);	
			}
			return returnColumnList;
		}

	
	/**
	 * 维度在指标上方
	 * 
	 * @param list
	 * @param beferColumnStr
	 *            左边维度列数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedList<LinkedList<JqueryDataGrid>> constructIndexUp(

	List<Map<String, List<Object>>> list, String beferColumnStr, UDbPtReport uDbPtReport, int indexNumber) {

		String[] columnnStr = beferColumnStr.split(",");

		int beferColumn = columnnStr.length;

		LinkedList<LinkedList<JqueryDataGrid>> returnColumnList = new LinkedList<LinkedList<JqueryDataGrid>>();

		//获取模板左边维度
		String leftDimField = uDbPtReport.getReportObject();
		
		for (int i = 0; i < list.size(); i++) {
			LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();

			// 拼装纵向维度列数表头start6
			if (i == 0) {
				if (uDbPtReport.getReportReverse() == 1) {
					//beferColumn = beferColumn + 1;
					for (int j = 0; j < beferColumn; j++) {
						JqueryDataGrid sizeColumn = new JqueryDataGrid();
						sizeColumn.setAlign("center");
						sizeColumn.setRowspan(list.size());
						sizeColumn.setField("v" + j);
						if(j<columnnStr.length){
							sizeColumn.setTitle(columnnStr[j]);
						}
						columnList.add(sizeColumn);
					}

				} else {

					for (int j = 0; j < beferColumn; j++) {
						JqueryDataGrid sizeColumn = new JqueryDataGrid();
						sizeColumn.setWidth(width);
						sizeColumn.setTitle(columnnStr[j]);
						sizeColumn.setAlign("center");
						sizeColumn.setRowspan(list.size());
						sizeColumn.setField("v" + j);
						columnList.add(sizeColumn);
					}
				}
			}
			
			// 拼装纵向维度列数表头end
			Object obj = list.get(i);
		    if (obj instanceof LinkedMap) {
		    	LinkedMap subMap = (LinkedMap) obj;
		    	Iterator it = subMap.entrySet().iterator();
		    	int j = beferColumn;
				while (it.hasNext()) {
					Map.Entry entry= (Entry) it.next(); 
					String key = (String) entry.getKey();
					List<String> subList = (List<String>) entry.getValue();
					for (String value : subList) {
						int size = 0;
						if(i<list.size()-1){
							//if(key.equals(value)){
							if(i==0){ //表头第一层
								size += getColspan(list,value);
							}else{
								size += getColspan(list, key +columnSeparator+value);
							}
						}else{
							size = 1;
						}
						JqueryDataGrid sizeColumn = new JqueryDataGrid();
						sizeColumn.setTitle(value);
						if(size ==0){
							continue;
						}
						sizeColumn.setColspan(size);
						if (i == list.size() - 1) {
							sizeColumn.setAlign("right");
							sizeColumn.setField("v" + j);
							//如果模板有总计，或者有合并单元格，或者有行列转换的时候，不做指标排序
							if ((uDbPtReport.getReportReverse() != 1)
									&& (uDbPtReport.getLineCount().intValue() != 1) 
									&& (uDbPtReport.getColsCount().intValue() != 1)
									&& (uDbPtReport.getIsStack().intValue() != 1)
									&& (leftDimField.indexOf("同比and日期") == -1)) {
								sizeColumn.setSortable(true);
							}
						}
						sizeColumn.setWidth(width);
						columnList.add(sizeColumn);
						j++;
					}
				}
				returnColumnList.add(columnList);
			}
		}

		return returnColumnList;

	}

	/**
	 * 维度在指标下方
	 * 
	 * @param list
	 * @param beferColumnStr
	 *            左边维度列数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedList<LinkedList<JqueryDataGrid>> constructIndexDown(
			List<Map<String, List<Object>>> list, String beferColumnStr, UDbPtReport uDbPtReport, int indexNumber) {
		

		String[] columnnStr = beferColumnStr.split(",");

		int beferColumn = columnnStr.length;

		LinkedList<LinkedList<JqueryDataGrid>> returnColumnList = new LinkedList<LinkedList<JqueryDataGrid>>();

		Object obj = list.get(list.size() - 1);
		
		// 构造指标在上的第一行表头
		if (obj instanceof LinkedMap) {

			LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();

			// 拼装纵向维度列数表头start
			if (uDbPtReport.getReportReverse() == 1) {
				beferColumn = beferColumn + 1;
				for (int j = 0; j < beferColumn; j++) {
					JqueryDataGrid sizeColumn = new JqueryDataGrid();
					sizeColumn.setAlign("center");
					sizeColumn.setRowspan(list.size());
					sizeColumn.setField("v" + j);
					columnList.add(sizeColumn);
				}
			} else {
				for (int j = 0; j < beferColumn; j++) {
					JqueryDataGrid sizeColumn = new JqueryDataGrid();
					sizeColumn.setTitle(columnnStr[j]);
					sizeColumn.setAlign("center");
					sizeColumn.setRowspan(list.size());
					sizeColumn.setField("v" + j);
					columnList.add(sizeColumn);
				}
			}
			// 拼装纵向维度列数表头end

			String keyList = "";
			LinkedMap subMap = (LinkedMap) obj;
			Iterator<?> it = subMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry= (Entry) it.next(); 
				String key = (String) entry.getKey();
				List<String> subList = (List) entry.getValue();
				for (String str : subList) {
					keyList += key + columnSeparator + str + ",";
				}
				break;
			}
			while (keyList.endsWith(",")) {
				keyList = keyList.substring(0, keyList.length() - 1);
			}

			//计算第一层跨列数,指标在上方跨列数相同
			int size  = 0;
			LinkedMap map = (LinkedMap) list.get(0);
			Iterator iterator  = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry= (Entry) iterator.next(); 
				String key = (String) entry.getKey();
				size += getColspan(1,list, key);
			}
			
			for (String key : keyList.split(",")) {
				JqueryDataGrid sizeColumn = new JqueryDataGrid();
				String keyStr = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
				sizeColumn.setTitle(keyStr);
				sizeColumn.setAlign("center");
				sizeColumn.setColspan(size);
				sizeColumn.setAlign("right");
				columnList.add(sizeColumn);
			}
			returnColumnList.add(columnList);

		}
		

		// 拼装维度开始
		for (int i = 0; i < list.size() - 1; i++) {

			LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();

			obj = list.get(i);
			
			if (obj instanceof LinkedMap) {

				String keyList = "";
				LinkedMap subMap = (LinkedMap) obj;
				Iterator<?> it = subMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry= (Entry) it.next(); 
					String key = (String) entry.getKey();
					List<String> subList = (List) entry.getValue();
					for (String str : subList) {
						keyList += key + columnSeparator + str + ",";
					}
				}
				while (keyList.endsWith(",")) {
					keyList = keyList.substring(0, keyList.length() - 1);
				}
				
				if(i==list.size()-2){ //表头最后一行
					int j = beferColumn;
					for(int k=0;k<indexNumber;k++){
						for (String key : keyList.split(",")) {
							JqueryDataGrid sizeColumn = new JqueryDataGrid();
							String keyStr = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
							sizeColumn.setTitle(keyStr);
							sizeColumn.setAlign("center");
							int size = 1; // 表头最后一行不合并表头
							sizeColumn.setColspan(size);
							if (i == list.size() - 2) {
								sizeColumn.setColspan(0);
								sizeColumn.setWidth(width);
								sizeColumn.setAlign("right");
								sizeColumn.setField("v" + j);
							}
							columnList.add(sizeColumn);
							j++;
						}
					}
					
				}else{
					for(int k=0;k<indexNumber;k++){
						for (String key : keyList.split(",")) {
							JqueryDataGrid sizeColumn = new JqueryDataGrid();
							String keyStr = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
							sizeColumn.setTitle(keyStr);
							sizeColumn.setAlign("center");
							int size = getColspan(1,list, key);
						    if(size==0){
						    	continue;
						    }
							size = size > 1 ? size : 0; // 表头最后一行不合并表头
							sizeColumn.setColspan(size);
							columnList.add(sizeColumn);
						}
					}
				}
				
				returnColumnList.add(columnList);
			}
		}

		return returnColumnList;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,Integer> getLastColumn(UDbPtReport uDbPtReport, List list){
		int indexNumber = 0;
		//List<Map<String,Integer>> indexNumberList = new ArrayList<Map<>>();
		Map<String,Integer> indexNumberMap = new LinkedMap();
		if (uDbPtReport.getReportReverse() == 1) {
			if(list != null && list.size()>0){
				Object obj = null;
				obj = list.get(list.size()-1);
				if(obj instanceof LinkedMap){
					Map map = (Map) obj;
					Iterator it = map.entrySet().iterator();
					while(it.hasNext()){
						Map.Entry entry= (Entry) it.next(); 
						String key = (String) entry.getKey();
						List value = (List) entry.getValue();
						indexNumber = value==null ? 1  : value.size();
						if(key.indexOf(columnSeparator)>-1){
							String[] temp  = key.split(columnSeparator);
							key =temp[temp.length-1];
						}
						indexNumberMap.put(key, indexNumber);
					}
				}
			}
		}
		return indexNumberMap;
	}

	/**
	 * 所有维度并列显示
	 * @param list
	 * @param beferColumnStr
	 *            左边维度列数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedList<LinkedList<JqueryDataGrid>> constructIndexStand(
			List<Map<String, List<Object>>> list, String beferColumnStr, UDbPtReport uDbPtReport, int indexNumber) {

		if (list == null || list.size() == 0) {
			return null;
		}

		String keyList = "";
		
		String[] columnnStr = beferColumnStr.split(",");
		int beferColumn = columnnStr.length;

		LinkedList<LinkedList<JqueryDataGrid>> returnColumnList = new LinkedList<LinkedList<JqueryDataGrid>>();

		// 拼装纵向维度列数表头start
		if (uDbPtReport.getReportReverse() == 1) {
			LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();
			beferColumn = beferColumn + 1;
			for (int j = 0; j < beferColumn; j++) {
				JqueryDataGrid sizeColumn = new JqueryDataGrid();
				sizeColumn.setAlign("center");
				sizeColumn.setRowspan(list.size());
				sizeColumn.setField("v" + j);
				columnList.add(sizeColumn);
			}
			
			// 拼装纵向维度列数表头end

			// 拼装横向维度列数表头
			Object obj = list.get(0);
			if (obj instanceof LinkedMap) {
				String keyStr = "";
				LinkedMap subMap = (LinkedMap) obj;
				Iterator<?> it = subMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry= (Entry) it.next(); 
					String key = (String) entry.getKey();
					List<String> subList = (List) entry.getValue();
					for (String str : subList) {
						keyStr += key + columnSeparator + str + ",";
					}
				}
				while (keyList.endsWith(",")) {
					keyStr = keyStr.substring(0, keyStr.length() - 1);
				}

				int j = beferColumn;
				for (int i = 0; i < keyList.split(",").length; i++) {
					for (String key : keyStr.split(",")) {
						JqueryDataGrid sizeColumn = new JqueryDataGrid();
						String title = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
						sizeColumn.setTitle(title);
						sizeColumn.setAlign("center");
						int size = 0; // 表头最后一行不合并表头
						sizeColumn.setColspan(size);
						sizeColumn.setWidth(width);
						sizeColumn.setAlign("right");
						sizeColumn.setField("v" + j);
						columnList.add(sizeColumn);
						j++;
					}
				}
			}
			returnColumnList.add(columnList);

		} else {

			LinkedList<JqueryDataGrid> columnList = new LinkedList<JqueryDataGrid>();
			for (int j = 0; j < beferColumn; j++) {
				JqueryDataGrid sizeColumn = new JqueryDataGrid();
				sizeColumn.setTitle(columnnStr[j]);
				sizeColumn.setAlign("center");
				sizeColumn.setRowspan(list.size());
				sizeColumn.setField("v" + j);
				columnList.add(sizeColumn);
			}
			
			// 拼装横向维度列数表头
			Object obj = list.get(0);
			if (obj instanceof LinkedMap) {
				String keyStr = "";
				LinkedMap subMap = (LinkedMap) obj;
				Iterator<?> it = subMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry= (Entry) it.next(); 
					String key = (String) entry.getKey();
					List<String> subList = (List) entry.getValue();
					for (String str : subList) {
						keyStr += key + columnSeparator + str + ",";
					}
				}
				while (keyList.endsWith(",")) {
					keyStr = keyStr.substring(0, keyStr.length() - 1);
				}

				for (int i = 0; i < keyList.split(",").length; i++) {
					for (String key : keyStr.split(",")) {
						JqueryDataGrid sizeColumn = new JqueryDataGrid();
						String title = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
						sizeColumn.setTitle(title);
						sizeColumn.setAlign("center");
						int size = 2; // 表头最后一行不合并表头
						size = getColspan(list,title);
						sizeColumn.setColspan(size);
						sizeColumn.setAlign("right");
						columnList.add(sizeColumn);
					}
				}
			}
			returnColumnList.add(columnList);
			
			// 拼装指标列数表头
			obj = list.get(1);
			if (obj instanceof LinkedMap) {
				String keyStr = "";
				LinkedMap subMap = (LinkedMap) obj;
				Iterator<?> it = subMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry= (Entry) it.next(); 
					String key = (String) entry.getKey();
					List<String> subList = (List) entry.getValue();
					for (String str : subList) {
						keyStr += key + columnSeparator + str + ",";
					}
				}
				while (keyList.endsWith(",")) {
					keyStr = keyStr.substring(0, keyStr.length() - 1);
				}

				int j = beferColumn;
				
				columnList = new LinkedList<JqueryDataGrid>();
				
				for (int i = 0; i < keyList.split(",").length; i++) {
					for (String key : keyStr.split(",")) {
						JqueryDataGrid sizeColumn = new JqueryDataGrid();
						String title = key.indexOf(columnSeparator) > -1 ? key.split(columnSeparator)[key.split(columnSeparator).length - 1] : key;
						sizeColumn.setTitle(title);
						sizeColumn.setAlign("center");
						int size = 0; // 表头最后一行不合并表头
						sizeColumn.setColspan(size);
						sizeColumn.setWidth(width);
						sizeColumn.setAlign("right");
						sizeColumn.setField("v" + j);
						columnList.add(sizeColumn);
						j++;
					}
				}
			}
			returnColumnList.add(columnList);

		}

		return returnColumnList;

	}
	

	
	/**
	 * 递归求跨列数 维度在指标上方
	 * @param colspan
	 * @param list
	 * @param key
	 * @param i
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static int getColspan(
			List<Map<String, List<Object>>> list, String key) {
		
		int colspan = 0;
		Map leafMap = list.get(list.size()-1);
		Iterator it = leafMap.entrySet().iterator();
		int i=0;
		while(it.hasNext()){
			Map.Entry entry= (Entry) it.next(); 
			String keyStr = (String) entry.getKey();
			List<String> keyList = Arrays.asList(keyStr.split(columnSeparator));
			List<String> parmKeyList  = Arrays.asList(key.split(columnSeparator));
			if(keyList.size()>parmKeyList.size() && i==0){ //首次判断
				key = key+"##";
			}
			if(keyList.size() == parmKeyList.size()){
				if(keyStr.equals(key)){
					List result = (List)entry.getValue();
					if(result != null && result.size()>0){
						colspan += result.size();
					}
				}
			}else if(keyStr.startsWith(key)){
				List result = (List)entry.getValue();
				if(result != null && result.size()>0){
					colspan += result.size();
				}
			}
			i++;
		}
		return colspan;
	}
	

	/**
	 * 维度在指标下方
	 * 递归求跨列数
	 * @param colspan
	 * @param list
	 * @param key
	 * @param i
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static int getColspan(int colspan, List<Map<String, List<Object>>> list, String key) {
		colspan = 0;
		Map leafMap = list.get(list.size()-2);
		Iterator it = leafMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry= (Entry) it.next(); 
			String keyStr = (String) entry.getKey();
			if(key.indexOf(columnSeparator)>-1){
				String array[] = key.split(columnSeparator);
				if(array[0].equals(array[1])){
					key  = array[0];
				}
			}
			if(keyStr.startsWith(key)){
				List result = (List)entry.getValue();
				if(result != null && result.size()>0){
					colspan += result.size();
				}
				if(keyStr.equals(key)){
					break;
				}
			}
		}
		return colspan;
	}

	/**
	 * 生成动态对象
	 * 
	 * @return
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<DynamicBean> makeData(List<String> object) {

		List<DynamicBean> result = new LinkedList<DynamicBean>();
		try {
			// 1. 校验是否存在
			if (object == null || object.size() == 0) {
				return null;
			}

			Map propertyMap = new HashMap();
			for (int i = 0; i < object.size(); i++) {
				String obj = object.get(i);
				String[] keys = obj.split(columnSeparator);
				for (int j = 0; j < keys.length; j++) {
					String strColumnName = "v" + j;
					propertyMap.put(strColumnName,
							Class.forName("java.lang.String"));
				}

				DynamicBean bean = new DynamicBean(propertyMap);
				for (int j = 0; j < keys.length; j++) {
					String strColumnName = "v" + j;
					bean.setValue(strColumnName, keys[j]);
				}
				result.add(bean);
				propertyMap.clear();
			}
		} catch (Exception e) {
			logger.error("数据映射到表格过程中出现异常",e);
		}
		return result;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> builderParams(HttpServletRequest req) {
		Map<String, Object> retParams = new HashMap<String,Object>(req.getParameterMap().size());
		Map<String, String[]> params = req.getParameterMap();
		if (null != params && params.size() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Entry<String, String[]> p : params.entrySet()) {
				if (p.getValue() == null || StringUtils.isEmpty(p.getValue().toString()))
					continue;
				// 只转换一个参数，多个参数不转换
				String values[] = (String[]) p.getValue();
				String match = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
				if (values[0].matches(match)) {
					try {
						retParams.put(p.getKey(), sdf.parse(values[0]));
					} catch (ParseException e) {
						retParams.put(p.getKey(), values);
						e.printStackTrace();
					}
				} else {
					retParams.put(p.getKey(), values[0]);
				}
			}
		}
		
		//固定报表模式可配项
		if(!req.getServletPath().startsWith("/template_report/")&&!req.getServletPath().startsWith("/member_template_report/")){
			
			retParams.put("schema", PublicConstans.fixed_schema);
		}
		return retParams;
	}

}
