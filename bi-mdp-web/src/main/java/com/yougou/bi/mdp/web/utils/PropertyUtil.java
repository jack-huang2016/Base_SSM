package com.yougou.bi.mdp.web.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil {

	/**
	 * 日志服务
	 */
	private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

	/**
	 * 往properties文件设置键值对内容
	 * 
	 * @param keyToValueMap
	 * @param fileName
	 * @throws IOException
	 */
	public static void setWebPropertyValue(Map<String, String> keyToValueMap,
			String fileName) throws IOException {
		Properties prop = new Properties();
        
		String path = new PropertyUtil().getClass().getResource("/").getPath();
		path = path + fileName;// "fixedReport.properties";
		path = File.separator.equals("/") ? "/" + path : path;
		// 读取属性文件a.properties
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			// 先把写入前文件中的键值对，放入到集合中来
			while (it.hasNext()) {
				String key = it.next();
				if (!keyToValueMap.containsKey(key)) {
					String value = prop.getProperty(key);
					keyToValueMap.put(key, value);
				}
			}
			// 写入文件
			for (Iterator<Entry<String, String>> entryIt = keyToValueMap
					.entrySet().iterator(); entryIt.hasNext();) {
				Entry<String, String> entry = entryIt.next();
				String key = entry.getKey();
				String value = entry.getValue();
				prop.setProperty(key, value);
			}
			OutputStream outputFile = new FileOutputStream(path); 
			prop.store(outputFile,"dispatchExecuteResult"); 
		} catch (FileNotFoundException e) {
			logger.error(path+"路径下文件找不到",e);
		} catch (IOException e) {
			logger.error("IO异常",e);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	public static String getWebPropertyValue(String keyName, String fileName)
			throws IOException {
		String res = "";
		Properties prop = new Properties();

		String path = new PropertyUtil().getClass().getResource("/").getPath();
		path = path + fileName;// "fixedReport.properties";
		path = File.separator.equals("/") ? "/" + path : path;

		// 读取属性文件a.properties
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				if (key.equals(keyName)) {
					res = prop.getProperty(key);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			logger.error(path+"路径下文件找不到",e);
		} catch (IOException e) {
			logger.error("IO异常",e);
		} finally {
			IOUtils.closeQuietly(in);
		}
		return res;
	}

	public static String getPropertyValue(String fileName, String keyName) {
		String res = "";
		Properties prop = new Properties();
		String path = fileName;
		path = File.separator.equals("/") ? "/" + path : path;
		if (File.separator.equals("\\")) { // windows系统需要拷贝文件到指定目录
			String srcDirName = "D:/yougouconf/bi/mdp/dal-redis-config.properties";
			String destDirName = "/etc/wonhighconf/bi/mdp/dal-redis-config.properties";
			copyFile(srcDirName, destDirName, true);
		}

		// 读取属性文件a.properties
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				if (key.equals(keyName)) {
					res = prop.getProperty(key);
				}
			}
		} catch (Exception e) {
			logger.error("IO异常",e);
		} finally {
			IOUtils.closeQuietly(in);
		}
		return res;
	}

	/**
	 * 复制单个文件
	 * 
	 * @param srcFileName
	 *            待复制的文件名
	 * @param descFileName
	 *            目标文件名
	 * @param overlay
	 *            如果目标文件存在，是否覆盖
	 * @return 如果复制成功返回true，否则返回false
	 */
	public static boolean copyFile(String srcFileName, String destFileName,
			boolean overlay) {
		File srcFile = new File(srcFileName);

		// 判断源文件是否存在
		if (!srcFile.exists()) {
			return false;
		} else if (!srcFile.isFile()) {
			return false;
		}

		// 判断目标文件是否存在
		File destFile = new File(destFileName);
		if (destFile.exists()) {
			// 如果目标文件存在
			if (overlay) {
				// 删除已经存在的目标文件，无论目标文件是目录还是单个文件
				new File(destFileName).delete();
			}
		} else {
			// 如果目标文件所在目录不存在，则创建目录
			if (!destFile.getParentFile().exists()) {
				// 目标文件所在目录不存在
				if (!destFile.getParentFile().mkdirs()) {
					// 复制文件失败：创建目标文件所在目录失败
					return false;
				}
			}
		}

		// 复制文件
		int byteread = 0; // 读取的字节数
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];

			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}
