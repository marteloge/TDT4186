package Oving3;


public class Io {
	
	private Queue ioQueue;
	private Statistics statistics;
	private long ioWait;
	private Gui gui;

	private Process activeProcess = null;


	public IO(Queue ioQueue, Statistics statistics, EventQueue eventQueue, long ioWait, Gui g) {
		this.ioQueue = ioQueue;
		this.statistics = statistics;
		this.gui = g;
		this.ioWait = ioWait;

	}

}
