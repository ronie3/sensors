package com.example.ronald.sensors;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class phonesensors extends AppCompatActivity {
    private SensorManager mgr ;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonesensors);
        mgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        txt = (TextView) findViewById(R.id.textView2);
        List<Sensor> sensorList = mgr.getSensorList(Sensor.TYPE_ALL);
        StringBuilder stringBuilder = new StringBuilder();
        for (Sensor s : sensorList) {
            stringBuilder.append(s.getName() + "\n");

            txt.setVisibility(View.VISIBLE);
            txt.setText(stringBuilder);
        }
    }


}