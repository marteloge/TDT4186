package Oving3;

public class Cpu {

	private Queue cpuQueue;
	private Statistics statistics;
	private Process activeProcess;
	private Gui gui;
	private long maxCpuTime;

	
	public CPU(Queue cpuQueue, Statistics statistics, Gui gui, long maxCpuTime){
		this.cpuQueue = cpuQueue;
		this.statistics = statistics;
		this.maxCpuTime = maxCpuTime;
		this.gui = gui;

	}
	
	
	public void instertProcess(Process p){
		cpuQueue.insert(p);
	}
	
	public boolean CPUisIdle(){
		return this.activeProcess == null;
	}
	
	public Process getActive(){
		Process temp = this.activeProcess;
		this.activeProcess = null;
		return temp;
	}
	
	public void updateTime(long timepassed){
		//TODO: Skrive denne metoden!
	}
	
	



}
