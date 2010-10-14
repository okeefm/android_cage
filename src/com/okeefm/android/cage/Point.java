package com.okeefm.android.cage;

public class Point {
	private float x;
	private float y;
	private float z;
	private long time;
	
	public Point(float x, float y, float z, long time) {
		this.x = x;
		this.y = y;
		this.z = z;
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
