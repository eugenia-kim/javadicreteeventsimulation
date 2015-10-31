package ssq;

import simulation.Event;

public class Arrival implements Event<SingleServerQueue> {

	public Arrival() {
		
	}
	@Override
	public void invoke(SingleServerQueue s) {
		s.increasePopulation();
		System.out.println("Arrival at " + s.getCurrentTime() + ", new population = " + s.getPopulation());
		if (s.getPopulation() == 1) {
			s.schedule(new Departure(), s.getCurrentTime() + s.SERVICE_TIME);
		}
		s.schedule(new Arrival(), s.getCurrentTime() + s.getRandom());
		
	}

}
