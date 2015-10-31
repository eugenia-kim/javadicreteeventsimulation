package ssq;

import java.util.Random;

import simulation.Simulation;

public class SingleServerQueue extends Simulation<SingleServerQueue> {

	final double SERVICE_TIME = 0.25;
	private double totalTime;
	private int population;
	private Random rg;
	private double currentMeanQueueLength;
	private double previousTime;
	
	private SingleServerQueue(long seed, double tt) {
		this.totalTime = tt;
		this.population = 0;
		this.rg = new Random(seed);
		this.currentMeanQueueLength = 0.0;
		this.previousTime = 0.0;
	}
	
	double getRandom() {
		return this.rg.nextDouble();
	}
	
	int getPopulation() {
		return population;
	}
	
	void increasePopulation() {
		updateLength();
		population++;
	}
	
	void decreasePopulation() {
		updateLength();
		population--;
	}
	
	private void updateLength() {
		currentMeanQueueLength += population * (getCurrentTime()- previousTime); 
		previousTime = getCurrentTime();
	}
	
	
	@Override
	protected boolean stop() {
		return this.getCurrentTime() >= this.totalTime;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleServerQueue s = new SingleServerQueue(Long.parseLong(args[0]), Double.parseDouble(args[1]));
		s.schedule(new Arrival(), s.getRandom());
		s.simulate();
		System.out.println ("SIMULATION COMPLETE - the mean queue length was " + s.getMeanQueueLength());
	}

	@Override
	protected SingleServerQueue getState() {
		return this;
	}
	
	private double getMeanQueueLength() {
		return (currentMeanQueueLength + (totalTime - previousTime)*population)/totalTime;
	}

}
