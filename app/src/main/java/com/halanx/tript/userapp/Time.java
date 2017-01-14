package com.halanx.tript.userapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RadioGroup;

public class Time extends Activity {

    RadioGroup radioGroup ;
    int checked;
    public final static String EXTRA_MESSAGE = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Log.e("TAG", "started time activity");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8),(int) (height*0.6));

        radioGroup = (RadioGroup) findViewById(R.id.radG);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checked = radioGroup.indexOfChild(findViewById(checkedId));
                switch (checked){
                    case 0:
                        {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"1:00 - 2:00 a.m");
                        startActivity(intent);
                        break;}
                    case 1:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"2:00 - 3:00 a.m");
                        startActivity(intent);
                        break;}
                    case 2:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"3:00 - 4:00 a.m");
                        startActivity(intent);
                        break;}

                    case 3:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"4:00 - 5:00 a.m");
                        startActivity(intent);
                        break;}

                    case 4:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"5:00 - 6:00 a.m");
                        startActivity(intent);
                        break;}

                    case 5:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"6:00 - 7:00 a.m");
                        startActivity(intent);
                        break;}

                    case 6:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"7:00 - 8:00 a.m");
                        startActivity(intent);
                        break;}

                    case 7:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"8:00 - 9:00 a.m");
                        startActivity(intent);
                        break;}

                    case 8:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"9:00 - 10:00 a.m");
                        startActivity(intent);
                        break;}

                    case 9:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"10:00 - 11:00 a.m");
                        startActivity(intent);
                        break;}

                    case 10:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"11:00 - 12:00 p.m");
                        startActivity(intent);
                        break;}

                    case 11:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"12:00 - 1:00 p.m");
                        startActivity(intent);
                        break;}

                    case 12:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"1:00 - 2:00 p.m");
                        startActivity(intent);
                        break;}

                    case 13:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"2:00 - 3:00 p.m");
                        startActivity(intent);
                        break;}

                    case 14:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"3:00 - 4:00 p.m");
                        startActivity(intent);
                        break;}

                    case 15:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"4:00 - 5:00 p.m");
                        startActivity(intent);
                        break;}

                   case 16:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"5:00 - 6:00 p.m");
                        startActivity(intent);
                        break;}

                    case 17:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"6:00 - 7:00 p.m");
                        startActivity(intent);
                        break;}

                    case 18:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"7:00 - 8:00 p.m");
                        startActivity(intent);
                        break;}

                    case 19:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"8:00 - 9:00 p.m");
                        startActivity(intent);
                        break;}

                    case 20:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"9:00 - 10:00 p.m");
                        startActivity(intent);
                        break;}

                    case 21:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"10:00 - 11:00 p.m");
                        startActivity(intent);
                        break;}

                    case 22:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"11:00 - 12:00 a.m");
                        startActivity(intent);
                        break;}

                    case 23:
                    {Intent intent= new Intent(Time.this,Call_Popups.class);
                        intent.putExtra(EXTRA_MESSAGE,"12:00 - 1:00 a.m");
                        startActivity(intent);
                        break;}
                }
            }
        });
    }
}
