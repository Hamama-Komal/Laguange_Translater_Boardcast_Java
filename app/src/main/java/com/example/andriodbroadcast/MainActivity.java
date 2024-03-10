package com.example.andriodbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.example.andriodbroadcast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    static final int ALARM_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        binding.btnSetTime.setOnClickListener(view -> {

            int time = Integer.parseInt(binding.edtTime.getText().toString());
            long triggerTime = System.currentTimeMillis() + (time * 1000);

            Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);


        });



    }
}