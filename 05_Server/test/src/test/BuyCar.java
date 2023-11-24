package test;

public class BuyCar {
	
	private Driver bestDriver;
	private Car carType;
	
	public BuyCar(Driver d) {
		this.bestDriver = d;
		this.carType = new Car();
	}
}