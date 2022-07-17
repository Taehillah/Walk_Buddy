package com.example.s43385508;
//43385508

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    EditText diHours, diMinutes;
    MaterialButton buttone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText
        diHours = findViewById(R.id.hours);
        diMinutes = findViewById(R.id.minutes);
        //Button
        buttone = findViewById(R.id.button);

        //Button click listener
        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                else {

    Intent i = new Intent(MainActivity.this, MainActivity2.class);
    i.putExtra("simplestDiMinutes", simplestDiMinutes);
    i.putExtra("simplestDiHours", simplestDiHours);
    startActivity(i);
    finish();
               }
            }
        });
    }
}