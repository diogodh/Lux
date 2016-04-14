package com.example.supermario.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mLight;
    private float lux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    //public void buttonOnClick(View v) {
    //Button button=(Button) v;
    //   ((Button) v).setText("Yeh");
    //  TextView text=(TextView)findViewById(R.id.TextView);
    //  text.setText(String.valueOf(lux));
    //}


    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        lux = event.values[0];
        TextView text=(TextView)findViewById(R.id.TextView);
        text.setText(String.valueOf(lux));

        //Button myButton = (Button) findViewById(R.id.button);
        //myButton.setText(String.valueOf(lux));
        //Do something with this sensor data.
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }
}
