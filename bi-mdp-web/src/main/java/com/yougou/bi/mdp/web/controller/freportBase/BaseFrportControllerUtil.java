package com.yougou.bi.mdp.web.controller.freportBase;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import com.yougou.bi.mdp.web.utils.PropertyUtil;
import com.yougou.bi.mdp.web.vo.CurrentUser;

public class BaseFrportControllerUtil {
	
	//1k=1024B
    public static final int SIZE = 1024; //单位是B
    
    public static final int BI_MAX_DATA_ROW = 50000; 
    
    //部分固定报表，每次刷500条到磁盘
    public static final int ROW_ACCESS = 500;
    
    protected static final XLogger logger = XLoggerFactory.getXLogger(BaseFrportControllerUtil.class);
    
    
	/**
	 * 在线导出固定报表的统一处理方法
	 * @param req 请求
	 * @param response 相应
	 * @param prefix 存到本地的文件名前缀
	 * @param suffix 存到本地的文件名后缀，有可能是xls，也有可能是.xlsx
	 * @param headerFileName 导出的报表名字
	 */
	public static void download(HttpServletRequest req, HttpServletResponse response, String prefix, String suffix,
			String headerFileName) {
		// 生成报表文件名称
		String fileName = createFileName(req, prefix, suffix);
		// 生成报表文件路径
		String destPath = BaseFrportControllerUtil.getDestPath(req, fileName);
		downLoadFile(response,prefix,suffix,headerFileName,destPath);
	}
	
	/**
	 * 在线导出固定报表的统一处理方法
	 * @param response 相应
	 * @param prefix 存到本地的文件名前缀
	 * @param suffix 存到本地的文件名后缀，有可能是xls，也有可能是.xlsx
	 * @param headerFileName 导出的报表名字
	 * @param destPath 导出的报表目录+文件名
	 */
	public static void downLoadFile(HttpServletResponse response, String prefix, String suffix,
			String headerFileName,String destPath){
		OutputStream os = null;
		BufferedOutputStream buff = null;
		File destFile = null;
		String headerFileNameStr = null;
		//如果headerFileName为空，则取fileTime为导出报表的文件名
		try {
			headerFileNameStr = new String((headerFileName + suffix).getBytes("utf-8"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			logger.error("导出报表异常，导出报表的报表是：" + prefix + ", 异常信息:" + e.getMessage());
		}
		try {
			destFile = new File(destPath);
			os = response.getOutputStream();
			response.reset(); // 来清除首部的空白行
			response.setHeader("Content-Disposition", "attachment; filename=" + headerFileNameStr);
			response.setContentType("application/octet-stream; charset=utf-8");
			
			//设置缓存的大小为64K
			buff = new BufferedOutputStream(os, 64*SIZE);
			buff.write(FileUtils.readFileToByteArray(destFile));
			buff.flush();
			
		} catch (UnsupportedEncodingException e) {
			logger.error("导出报表异常，导出报表的报表是：" + prefix + ", 异常信息:" + e.getMessage());
		} catch (IOException e) {
			logger.error("导出报表异常，导出报表的报表是：" + prefix + ", 异常信息:" + e.getMessage());
		} finally {
			// 关闭流对象必须放在finally里，否则出现IO异常的时候，流对象无法关闭
			IOUtils.closeQuietly(buff);
			IOUtils.closeQuietly(os);
		}
		destFile = null;  //废弃对象，垃圾回收
	}
	
	public static String createFileName(HttpServletRequest req, String prefix, String suffix){
		//如果suffix为空，则默认为".xls"
		if(null == suffix || suffix.isEmpty() ){
			suffix = ".xls";
		}
		// 获取前台传递过来的一个时间戳参数[用于生成xls表格的文件名]
		String fileTime = (String) req.getParameter("timestamp");
		// 获取系统userid用于生成xls表格文件名
		int userId = CurrentUser.getCurrentUser(req).getUserid();
		// 生成报表文件名称
		String fileName = prefix + userId + fileTime + suffix;
		return fileName;
	}
	
	/**
	 * 由于当前代码中在构造destPath的时候，有特殊的业务逻辑处理，所有需要新建一个方法直接处理这种情况，后缀格式固定
	 * @param req
	 * @param response
	 * @param destPath
	 * @param headerFileName
	 */
	public static void directDownload(HttpServletRequest req, HttpServletResponse response, String destPath,
			String headerFileName) {
		
		// 获取前台传递过来的一个时间戳参数[用于生成xls表格的文件名]
		String fileTime = (String) req.getParameter("timestamp");
		
		BufferedOutputStream buff = null;
		OutputStream os = null;
		File destFile = null;
		String headerFileNameStr = null;
		
		//如果headerFileName为空，则取fileTime为导出报表的文件名
		try {
			if(null != headerFileName && !headerFileName.isEmpty()){
				headerFileNameStr = new String((headerFileName).getBytes("utf-8"),"iso-8859-1");
			}else{
				headerFileNameStr = new String((fileTime).getBytes("utf-8"),"iso-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("导出报表异常，导出报表的报表是：" + headerFileName + ", 异常信息:" + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			
			destFile = new File(destPath);
			os = response.getOutputStream();
			response.reset(); // 来清除首部的空白行
			response.setHeader("Content-Disposition", "attachment; filename=" + headerFileNameStr);
			response.setContentType("application/octet-stream; charset=utf-8");
			
			//设置缓存的大小为64K
			buff = new BufferedOutputStream(os, 64*SIZE);
			buff.write(FileUtils.readFileToByteArray(destFile));
			buff.flush();
			
		} catch (UnsupportedEncodingException e) {
			logger.error("导出报表异常，导出报表的报表是：" + headerFileNameStr + ", 异常信息:" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("导出报表异常，导出报表的报表是：" + headerFileNameStr + ", 异常信息:" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 关闭流对象必须放在finally里，否则出现IO异常的时候，流对象无法关闭
			IOUtils.closeQuietly(buff);
			IOUtils.closeQuietly(os);
		}
		destFile = null;  //废弃对象，垃圾回收
    }
	
	public static String getSourcePath(HttpServletRequest req, String fileName) {
		String sourcePath = req.getSession().getServletContext()
				.getRealPath(System.getProperty("file.separator"))
				+ "WEB-INF"
				+ System.getProperty("file.separator")
				+ "xls"
				+ System.getProperty("file.separator")
				+ "freportSource"
				+ System.getProperty("file.separator") + fileName;
		return sourcePath;
	}

	public static String getDestPath(HttpServletRequest req, String fileName) {
		String destPath = getDestPath("FIXED_EXPORT_FILE_PATH2","/data/gfs/excel/freport");
		File file = new File(destPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		destPath = destPath + fileName;
		return destPath;
	}
	
	public static String getImportDestPath(HttpServletRequest req, String fileName) {
		String destPath = getDestPath("IMPORTEXCEL_PATH","/data/gfs/excel/importExcel");
		File file = new File(destPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		destPath = destPath + fileName;
		return destPath;
	}
	
	public static String getPicPath(String fileName) {
		String destPath = getDestPath("BI_PICPATH","/bi/freport/view/");;
		File file = new File(destPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		destPath = destPath + fileName;
		return destPath;
	}
	
	public static String getDestPath(String prefix, String init) {
		String destPath = "";
		try {
			destPath = PropertyUtil.getWebPropertyValue(prefix, "dispatch.properties");
		} catch (IOException e) {
			destPath = init;
		}
		return destPath;
	}
}
