package com.example.s43385508;
//43385508
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.MessageFormat;

public class MainActivity2 extends AppCompatActivity {

 TextView simplestResult1, simplestResult2;
 MaterialButton backButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Fullscreen mode activated by default
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //buttons and textview are referred to below:

        simplestResult1 = findViewById(R.id.medalEarned);
        simplestResult2 = findViewById(R.id.averageResults);

        Intent intent = getIntent();
        String simplestDiHours = intent.getStringExtra("simplestDiHours");
        String simplestDiMinutes = intent.getStringExtra("simplestDiMinutes");

        int huure = Integer.parseInt(simplestDiHours);
        int minute = Integer.parseInt(simplestDiMinutes);
        int timeHours = huure * 60;
        float timeRan = timeHours + minute;
        float averagePerHour = (float) (timeRan/42.2);

        ImageView pictureGold = (ImageView) findViewById(R.id.imgGold);
        ImageView pictureSilver = (ImageView)findViewById(R.id.imgSilver);
        ImageView pictureBronze = (ImageView)findViewById(R.id.imgBronze);

        if (averagePerHour<11)
        {
            pictureGold.setVisibility(View.VISIBLE);
            simplestResult1.setText(MessageFormat.format("You have run: {0} minute(s) every Kilometer", averagePerHour));
            simplestResult2.setText("Woooow! You have earned a Gold Medals");
        }
        else if (averagePerHour<15)
        {
            pictureSilver.setVisibility(View.VISIBLE);
            simplestResult1.setText(MessageFormat.format("You have run: {0}minute(s) every Kilometer", averagePerHour));
            simplestResult2.setText("Yeeey! You have earned a Silver Medals");
        }
        else
        {
            pictureBronze.setVisibility(View.VISIBLE);
            simplestResult1.setText(MessageFormat.format("You have run: {0}minute(s) every Kilometer", averagePerHour));
            simplestResult2.setText("You have earned a Bronze Medals");
        }

        //back Button
         backButton = findViewById(R.id.backArrow);

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity2.this,MainActivity.class);
               startActivity(intent);
               finish();
            }
        });

        //exitButton
        exitButton = findViewById(R.id.exit);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finishAffinity();
            }
        });
    }
}
