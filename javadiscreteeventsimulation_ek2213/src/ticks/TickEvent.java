package ticks;

import simulation.Event;

public class TickEvent implements Event<Ticks>{
	
	public TickEvent() {
		
	}
	
	@Override
	public void invoke(Ticks simulation) {
		System.out.println("Tick at: " + simulation.getCurrentTime());
		simulation.schedule(new TickEvent(), simulation.getCurrentTime() + Ticks.INTER_TICK_TIME);
	}
	
}
