package com.example.ronald.sensors;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
    SensorManager pato = null;//provides methods for accessing and listing sensors
    List list;
    TextView jose = null;
    SensorEventListener pato1 = new SensorEventListener()

    {
        @Override
        public void onSensorChanged(SensorEvent event)
        //it is where initialisation is done
        {
            float[] values = event.values;

            jose.setText("nx"+values[0]+"\ny:"+values[1]+"\nz:"+values[2]);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //invoked whenever sensor reports a new value
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pato = (SensorManager) getSystemService(SENSOR_SERVICE);
        jose = (TextView) findViewById(R.id.textview);
        list = pato.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (list.size() > 0) {
            // SensorEventListener pato1;

            pato.registerListener(pato1, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);//specified when registerlistener
        } else {
            Toast.makeText(getBaseContext(), "No accelerometer found!", Toast.LENGTH_SHORT).show();
        }
    }
public void phone(View view){
    Intent intent=new Intent(this,phonesensors.class);
    startActivity(intent);

    }
@Override
protected  void onStop(){

    if (list.size()>0){
    pato.unregisterListener(pato1);
}
super.onStop();
}
}
