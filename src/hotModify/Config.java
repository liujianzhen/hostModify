package hotModify;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config
{
	private static final File CONFIG_FILE = new File(Config.class.getResource("/").toString().substring(6)+"hotModify/config.properties");
	
	private static long lastModifyTime;
	
	private static Properties properties;

	/**
	 * Config 类加载时就读取配置文件信息
	 */
	static
	{
		try
		{
			loadConfig();
		} catch (Exception e)
		{
			System.err.println("加载配置文件失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取配置文件中的属性值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String getProperty(String key) throws Exception
	{
		if (isModified())
		{
			loadConfig();
		}
		return (String)properties.get(key);
	}
	
	/**
	 * 读取配置文件信息
	 * @throws Exception
	 */
	private static void loadConfig() throws Exception
	{
		FileInputStream is = new FileInputStream(CONFIG_FILE);
		properties = new Properties();
		properties.load(is);
		is.close();//一定要及时关闭流，不然会出现问题。
		lastModifyTime = CONFIG_FILE.lastModified();
	}
	
	/**
	 * 判断文件是否被修改过
	 * @return
	 */
	private static boolean isModified()
	{
		return CONFIG_FILE.lastModified() > lastModifyTime;
	}
}
