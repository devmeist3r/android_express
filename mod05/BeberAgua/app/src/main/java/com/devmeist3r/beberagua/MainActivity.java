package com.devmeist3r.beberagua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnNotify;
    private EditText edtMinutes;
    private TimePicker timePicker;

    private int hour;
    private int minute;
    private int interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btn_notify);
        edtMinutes = findViewById(R.id.edt_txt_number_interval);
        timePicker = findViewById(R.id.time_picker);

        timePicker.setIs24HourView(true);


    }

    public void notifyClick(View view) {
        String sInterval = edtMinutes.getText().toString();

        if (sInterval.isEmpty()) {
            Toast.makeText(this, R.string.error_msg, Toast.LENGTH_LONG).show();
            return;
        }

        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        interval = Integer.parseInt(sInterval);

        btnNotify.setText(R.string.pause);
        btnNotify.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));

        Log.d(
                "Teste",
                "hora: " + hour + " minutes: " + minute + " interval: " + interval);
    }

}
