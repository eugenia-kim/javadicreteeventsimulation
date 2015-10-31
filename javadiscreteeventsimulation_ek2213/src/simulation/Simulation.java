package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public abstract class Simulation<S> {
	
	private double cvt;
	private Queue<ScheduledEvent<S>> diary = new PriorityQueue<ScheduledEvent<S>>();
	
	public Simulation() {
		this.cvt = 0.0;
	}
	
	protected abstract S getState();
	
	protected abstract boolean stop();
	
	public void schedule(Event<S> e, double offset) {
		diary.add(new ScheduledEvent<S>(e,offset));
	}

	protected void simulate() {
		while(!diary.isEmpty()) {
			ScheduledEvent<S> current = diary.poll();
			cvt = current.getT();
			if(stop())
				break;
			current.getEvent().invoke(getState());
		}
		
	}

	public double getCurrentTime() {
		return cvt;
	}
}
