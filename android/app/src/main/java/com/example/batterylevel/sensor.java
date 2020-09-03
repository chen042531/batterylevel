package com.example.batterylevel;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

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
        eve.success(String.valueOf(sensorEvent.values[0]));
        Log.i("ren", String.valueOf(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
