package hotModify;

import java.io.File;

public class Test1
{
	private static final File CONFIG_FILE = new File(Test1.class.getResource("/").toString().substring(6)+"hotModify/config.properties");

	public static long get()
	{
		return CONFIG_FILE.lastModified();
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println(Test1.get());
		Thread.sleep(5*1000);
		System.out.println(Test1.get());
	}
}
