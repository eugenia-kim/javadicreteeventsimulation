package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

	private double totalTime;
	static final double INTER_TICK_TIME = 1.0;
	
	private Ticks(double tt) {
		this.totalTime = tt;
	}
	
	@Override
	protected boolean stop() {
		return this.getCurrentTime() >= this.totalTime;
	}

	public static void main(String args[]) {
	    Ticks p = new Ticks(Double.parseDouble(args[0]));
	    p.schedule(new TickEvent(), INTER_TICK_TIME);
	    p.simulate();
	  }

	@Override
	protected Ticks getState() {
		return this;
	}
}
