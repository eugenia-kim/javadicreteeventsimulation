package ssq;

import simulation.Event;

public class Departure implements Event<SingleServerQueue> {

	public Departure() {

	}
	@Override
	public void invoke(SingleServerQueue s) {
		s.decreasePopulation();
		System.out.println("Departure at " + s.getCurrentTime() + ", new population = " + s.getPopulation());
		if (s.getPopulation() > 0) {
			s.schedule(new Departure(), s.getCurrentTime() + s.SERVICE_TIME);
		}

	}

}
