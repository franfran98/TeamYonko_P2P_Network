package utils;

import interfaces.PositionI;

public class Position implements PositionI{
	private double x, y;

	public Position(int x, int y) {
		this.x = x; this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	static public double sqr(double x) {
	        return x*x;
	}
	
	@Override
	public double distance(PositionI other) {
		Position other_ = (Position) other;
		return Math.sqrt(sqr(other_.getY() - y) + sqr(other_.getX() - x));
	}

}
