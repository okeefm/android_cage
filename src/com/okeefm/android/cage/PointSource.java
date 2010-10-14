package com.okeefm.android.cage;

import java.util.concurrent.LinkedBlockingQueue;

import android.content.Context;

public class PointSource {
	private LinkedBlockingQueue <Point> points = new LinkedBlockingQueue<Point> ();
	private AccelerometerThread runLoop;
	private Exception problem = null;
	
	private volatile boolean doConnect = false;
	private volatile boolean doDisconnect = false;
	
	public PointSource (Context context) {
		runLoop = new AccelerometerThread(context);
		runLoop.start();
	}
	
	public void connect() {
		doConnect = true;
	}
	
	public void disconnect() {
		doDisconnect = true;
	}
	
	public Point take() throws Exception {
		if(problem != null) {
			Exception temp = problem;
			problem = null;
			throw temp;
		}
		return points.take();
	}

	private class AccelerometerThread extends Thread {
		private Accelerometer acc;
		public boolean readyToRun = false;

		
		public AccelerometerThread(Context context) {
			setAcc(context);
		}

		@Override
		public void run() {
			
		}
	
		private void setAcc(Context context) {
			acc = new Accelerometer(context);
			readyToRun = true;
		}
		
	}
}