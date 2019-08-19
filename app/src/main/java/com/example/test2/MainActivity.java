package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        textView2 = findViewById(R.id.tv2);
        textView2.setText(String.valueOf(new Date()));
    }

    public void openDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int date, int month, int year) {
               String reminderDat = ""+date+"-"+month+"-"+year;
              // Date date1 = new Date();
               Date date1 = new Date(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
               date1.setHours(2);
               date1.setMinutes(58);
                textView.setText(String.valueOf(date1));
            }
        },calendar.get(Calendar.DATE),calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR));
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE,0);
        datePickerDialog.getDatePicker().setMinDate(calendar1.getTimeInMillis());
        datePickerDialog.show();
    }
}
