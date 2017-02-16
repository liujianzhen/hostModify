package hotModify;

import java.util.TimerTask;

public class Test
{
	public static void main(String[] args) 
	{
		TimerTask task = new TimerTask()
		{
			@Override
			public void run()
			{
				try
				{
					System.out.println(Config.getProperty("name"));
					System.out.println(Config.getProperty("sex"));
					System.out.println(Config.getProperty("age"));
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer(0, 5*1000, task);
		timer.start();
	}
}
