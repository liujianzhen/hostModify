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
	 * Config �����ʱ�Ͷ�ȡ�����ļ���Ϣ
	 */
	static
	{
		try
		{
			loadConfig();
		} catch (Exception e)
		{
			System.err.println("���������ļ�ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�����ļ��е�����ֵ
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
	 * ��ȡ�����ļ���Ϣ
	 * @throws Exception
	 */
	private static void loadConfig() throws Exception
	{
		FileInputStream is = new FileInputStream(CONFIG_FILE);
		properties = new Properties();
		properties.load(is);
		is.close();//һ��Ҫ��ʱ�ر�������Ȼ��������⡣
		lastModifyTime = CONFIG_FILE.lastModified();
	}
	
	/**
	 * �ж��ļ��Ƿ��޸Ĺ�
	 * @return
	 */
	private static boolean isModified()
	{
		return CONFIG_FILE.lastModified() > lastModifyTime;
	}
}
