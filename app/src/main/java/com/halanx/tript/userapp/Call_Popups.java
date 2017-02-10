package com.halanx.tript.userapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class Call_Popups extends AppCompatActivity {

    EditText txt, txt2;
    int day_x, month_x, year_x;
    static final int DIALOG_ID =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__popups);

        final Calendar cal = Calendar.getInstance();
        txt = (EditText)findViewById(R.id.calendar);
        txt2 = (EditText) findViewById(R.id.time);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        month_x = cal.get(Calendar.MONTH);
        year_x = cal.get(Calendar.YEAR);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Call_Popups.this, Time.class));
            }
        });
        Intent intent = getIntent();
        String get_time = intent.getStringExtra(Time.EXTRA_MESSAGE);
        txt2.setText(get_time);

        showDialogOnButtonClick();

    }

    public void showDialogOnButtonClick(){
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID)
            return new DatePickerDialog(this, dPickerListener, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dPickerListener =
            new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                    year_x = year;
                    day_x = dayOfMonth;
                    month_x = monthOfYear;
                    String date = day_x+"/"+(month_x+1)+"/"+year_x ;
                    txt.setText(date);
                }
            };
}
