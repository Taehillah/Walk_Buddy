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

import java.text.MessageFormat;

public class MainActivity2 extends AppCompatActivity {

    public static final String Hora = "Hora";
    public static final String Motsotso = "Motsotso";

    private EditText val1;
    private EditText val2;
    private Button button;
    private String hr;
    private int min;
    private int defaultValue;
    private Object Visible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");

        Intent intent = getIntent();
        String simplestDiHours = intent.getStringExtra("SIMPLESTDIHOURS");
        String simplestDiMinutes = intent.getStringExtra("SIMPLESTDIMINUTES");

//textview fill
        TextView simplestResult1 = findViewById(R.id.hours);
        TextView simplestResult2 = findViewById(R.id.minutes);

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
        ImageButton backButton = findViewById(R.id.backArrow);

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        //exitButton
        TextView exitButton = findViewById(R.id.exit);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finishAffinity();
            }
        });
    }
}
