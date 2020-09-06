package com.example.batterylevel;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.ArrayList;

import io.flutter.plugin.common.EventChannel;

import static android.content.Context.SENSOR_SERVICE;

public class sensor implements SensorEventListener {
    private SensorManager sensorManager;
    public Context mContext;
    private EventChannel.EventSink eve;

    public sensor(Context mContext){
        Log.i("grgr","run");
        this.mContext = mContext;
        this.sensorManager = (SensorManager)mContext.getSystemService(SENSOR_SERVICE);
        Sensor mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, mAccelerometer, sensorManager.SENSOR_DELAY_NORMAL);
    }
    public sensor(Context mContext, final EventChannel.EventSink events){
        this.eve = events;
        this.mContext = mContext;
        this.sensorManager = (SensorManager)mContext.getSystemService(SENSOR_SERVICE);
        Sensor mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, mAccelerometer, sensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
//        ArrayList a = new ArrayList();
//        a.add(sensorEvent.values[0]);
//        a.add(sensorEvent.values[1]);
//        a.add(sensorEvent.values[2]);
        eve.success(String.valueOf(sensorEvent.values[0])+"  "+
                String.valueOf(sensorEvent.values[1])+"  "+
                String.valueOf(sensorEvent.values[2]));
        Log.i("ren", String.valueOf(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
