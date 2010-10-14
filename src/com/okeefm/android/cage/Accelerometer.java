package com.okeefm.android.cage;

import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer {
	private static SensorManager manager;
	private static Sensor acc;
	public boolean running = false;
	public boolean sensorSet = false;
	
	public Accelerometer(Context context) {
		getAccelerometer(context);
	}
	
	private void getAccelerometer(Context context) {
    	manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        List <Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        acc = sensorList.get(0);
        sensorSet = true;
    }
    
    public void connect(SensorEventListener listener) throws NotConnectedException {
    	boolean test = manager.registerListener(listener, acc, SensorManager.SENSOR_DELAY_FASTEST);
    	if (test == true) {
    		running = true;
    	}
    	else {
    		running = false;
    		throw new NotConnectedException("Listener couldn't connect");
    	}
    }
    
    public void disconnect(SensorEventListener listener)throws NotConnectedException {
    	if (running == true) {
    		manager.unregisterListener(listener, acc);
    		running = false;
    	}
    	else {
    		throw new NotConnectedException("Listener not connected");
    	}
    }

}
