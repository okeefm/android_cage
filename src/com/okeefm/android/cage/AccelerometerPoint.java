package com.okeefm.android.cage;

public class AccelerometerPoint {
	private float x;
	private float y;
	private float z;
	private long time;
	
	public AccelerometerPoint(float x, float y, float z, long time) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.time = time;
	}
	
	public AccelerometerPoint(float[] values, long time) {
		x = values[0];
		y = values[1];
		z = values[2];
		this.time = time;
		
	}

	public float[] pointArray() {
		float[] retArray = new float[3];
		retArray[0] = this.x;
		retArray[1] = this.y;
		retArray[2] = this.z;
		
		return retArray;
	}
	
	public long getTime() {
		return this.time;
	}

}
