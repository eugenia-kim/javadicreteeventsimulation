package simulation;

public class ScheduledEvent<S> implements Comparable<ScheduledEvent<S>>{
	private Event<S> event;
	private double fixedTime;
	
	public ScheduledEvent(Event<S> event, double fixedTime) {
		this.event = event;
		this.fixedTime = fixedTime;
	}
	
	public Event<S> getEvent() {
		return event;
	}

	public double getT() {
		return fixedTime;
	}
	
	@Override
	public int compareTo(ScheduledEvent<S> o) {
		return Double.compare(fixedTime, o.getT());
	}
	
}
