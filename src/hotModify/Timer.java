package hotModify;

import java.util.TimerTask;

/**
 * һ�����׵Ķ�ʱ��
 */
public class Timer
{
	private long delay;
	
	private long period;
	
	private TimerTask task;
	
	public Timer(long delay,long period,TimerTask task)
	{
		this.delay = delay;
		this.period = period;
		this.task = task;
	}
	
	public void setTimerTask(TimerTask task)
	{
		this.task = task;
	}
	
	public void start()
	{
		new java.util.Timer().schedule(task, delay, period);
	}
}
