package hotModify;

import java.util.TimerTask;

/**
 * 一个简易的定时器
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
