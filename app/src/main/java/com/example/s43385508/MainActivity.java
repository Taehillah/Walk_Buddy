package com.example.s43385508;
//43385508

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");

        //EditText
        EditText diHours = findViewById(R.id.hours);
        EditText diMinutes = findViewById(R.id.minutes);
        //Button
        Button buttone = findViewById(R.id.button);

        //Button click listener
        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //data from Edit texts
                String simplestDiHours = diHours.getText().toString();
                String simplestDiMinutes = diMinutes.getText().toString();

                if (TextUtils.isEmpty(diHours.getText().toString()))
                {
                    diHours.setError("Please enter the Hours you Ran");
                }
                else if (TextUtils.isEmpty(diMinutes.getText().toString()))
                {
                    diMinutes.setError("Please enter the Minutes you Ran");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("SIMPLESTDIMINUTES", simplestDiMinutes);
                    intent.putExtra("SIMPLESTDIHOURS", simplestDiHours);
                    startActivity(intent);
                }
            }
        });
    }
}