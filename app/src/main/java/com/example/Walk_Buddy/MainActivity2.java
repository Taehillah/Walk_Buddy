package com.example.Walk_Buddy;
/*
 * Name: Ishmael Lehlohonolo Mafole
 * Purpose: a_walk_buddy_that_allows_you_to_insert_your_time_for
 *          scores_enter_the_time_you_ran_below_then_press_submit.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.MessageFormat;

public class MainActivity2 extends AppCompatActivity {

 //spinner aka dropdown menu with medal names
 private Spinner spinner;
 private   final String[] paths = {"Gold_Medal", "Silver_Medal","Bronze_Medal"};
 TextView simplestResult1, simplestResult2;
 MaterialButton backButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Fullscreen mode activated by default with a clear task bar
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //buttons and textview are referred  to below located by IDs :
        simplestResult1 = findViewById(R.id.medalEarned);
        simplestResult2 = findViewById(R.id.averageResults);

        //collecting input data/information from MainActivity to MainActivity2
        Intent intent = getIntent();
        String simplestDiHours = intent.getStringExtra("simplestDiHours");
        String simplestDiMinutes = intent.getStringExtra("simplestDiMinutes");

        //declaration and conversion of strings passed from MainActivity.java and float time for accuracy
        int huure = Integer.parseInt(simplestDiHours);
        int minute = Integer.parseInt(simplestDiMinutes);
        int timeHours = huure * 60;
        float timeRan = timeHours + minute;
        float averagePerHour = (float) (timeRan/42.2);

        //drawing images from their ID's before making them an array of images
        ImageView pictureGold = (ImageView) findViewById(R.id.imgGold);
        ImageView pictureSilver = (ImageView)findViewById(R.id.imgSilver);
        ImageView pictureBronze = (ImageView)findViewById(R.id.imgBronze);

        //An Array of Images declared
        ImageView[] images = {pictureGold, pictureSilver,pictureBronze };


        if (averagePerHour<11)
        {
            images[0].setVisibility(View.VISIBLE); //an array with index 0 called to be visible
            simplestResult1.setText(MessageFormat.format("You have run: {0} minute(s) every Kilometer", averagePerHour));
            simplestResult2.setText("Woooow! You have earned a Gold Medals");
        }
        else if (averagePerHour<15)
        {
            images[1].setVisibility(View.VISIBLE); //an array with index 1 called to be visible
            simplestResult1.setText(MessageFormat.format("You have run: {0} minute(s) every Kilometer", averagePerHour));
            simplestResult2.setText("Yeeey! You have earned a Silver Medals");
        }
        else
        {
            images[2].setVisibility(View.VISIBLE); //an array with index 2 called to be visible
            simplestResult1.setText(MessageFormat.format("You have run: {0} minute(s) every Kilometer", averagePerHour));
            simplestResult2.setText("You have earned a Bronze Medals");
        }

        //back Button via ID
         backButton = findViewById(R.id.backArrow);

        backButton.setOnClickListener(view -> {
           Intent intent1 = new Intent(MainActivity2.this,MainActivity.class);
           startActivity(intent1);
           finish();
        });

        //exitButton using finishAffinity to kill the running app processes
        exitButton = findViewById(R.id.exit);

        exitButton.setOnClickListener(view -> finishAffinity());
    }
}
