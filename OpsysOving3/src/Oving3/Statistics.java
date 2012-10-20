package Oving3;

/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;///////////////
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;///////////////
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;///////////////
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;
	public long nofForcedSwitches = 0;
	public long nofProcessedIO = 0;
	public long totalCpuTime = 0;
	public long totalCpuTimeInQueue = 0;
	public long largestCpuQueue = 0;
	public long largestIoQueue = 0;
	public long cpuQueueTime = 0;
	public long ioQueueTime = 0;
	public long totalInCpuQueue = 0;
	public long totalInIoQueue = 0;
	public long totalIoTime = 0;
	public long totalIoTimeInQueue = 0;
	public long totalSystemTime;
	
    
	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                "
				+ nofCompletedProcesses);
		System.out.println("Number of created processes:                                  "
				+ nofCreatedProcesses);
		System.out.println("Number of (forced) process switches:                          "
				+ nofForcedSwitches);
		System.out.println("Number of processed I/O operations:                           "
				+ nofProcessedIO);
		System.out.println("Average throughput (processes per second):                    "
				+ ((float)nofCompletedProcesses/simulationLength*1000.0));
		System.out.println();
		
		
		System.out.println("Total CPU time spent processing:                              "
				+ totalCpuTime + " ms");
		//hvor mye % cpu arbeidet
		System.out.println("Fraction of CPU time spent processing:                        "
				+ (100.0*totalCpuTime/simulationLength) + " %");
		System.out.println("Total CPU time spent waiting:                                 "
				+ (simulationLength-totalCpuTime) + " ms");
		//hvor mye % cpu ventet
		System.out.println("Fraction of CPU time spent waiting:                           "
				+ (100.0*(simulationLength-totalCpuTime)/simulationLength) + " %");
		System.out.println();
		
		
		System.out.println("Largest occuring memory queue length:                         "
			+ memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "
				+ (float)memoryQueueLengthTime/simulationLength);
		if(nofCompletedProcesses > 0) {
			System.out.println("Largest occuring cpu queue length:                            "
					+ largestCpuQueue);
			System.out.println("Average cpu queue length:                                     "
					+ (float)cpuQueueTime/simulationLength);
			System.out.println("Largest occuring I/O queue length:                            "
					+ largestIoQueue);
			System.out.println("Average I/O queue length:                                     "
					+ (float)ioQueueTime/simulationLength);
			//blir bare plassert 1 gang
			System.out.println("Average # of times a process has been placed in memory queue: "
					+ 1);
			System.out.println("Average # of times a process has been placed in cpu queue:    "
					+ (float)totalInCpuQueue/nofCompletedProcesses);
			System.out.println("Average # of times a process has been placed in I/O queue:    "
					+ (float)totalInIoQueue/nofCompletedProcesses);
			System.out.println();
			
			System.out.println("Average time spent in system per process:                     "
					+ (float) totalSystemTime / nofCompletedProcesses);
			System.out.println("Average time spent waiting for memory per process:            "
					+totalTimeSpentWaitingForMemory/nofCompletedProcesses + " ms");
			System.out.println("Average time spent waiting for cpu per process:               "
					+ (float)totalCpuTimeInQueue/nofCompletedProcesses + " ms");
			System.out.println("Average time spent processing per process:                    "
					+ (float)totalCpuTime/nofCompletedProcesses + " ms");
			System.out.println("Average time spent waiting for I/O per process:               "
					+ (float)totalIoTimeInQueue/nofCompletedProcesses + " ms");
			System.out.println("Average time spent in I/O per process:                        "
					+ (float)totalIoTime/nofCompletedProcesses + " ms");
		}	
	}
}
