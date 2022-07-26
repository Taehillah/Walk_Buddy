package com.example.s43385508;
//43385508

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {
  private  EditText diHours, diMinutes;
    private  SwitchCompat dark_mode;
  private  RelativeLayout background;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText
        diHours = findViewById(R.id.hours);
        diMinutes = findViewById(R.id.minutes);
        //Button
        MaterialButton buttone = findViewById(R.id.button);
        dark_mode = findViewById(R.id.theme);
        //
        background = findViewById(R.id.layout);

        //Fullscreen mode activated by default
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        dark_mode.setOnClickListener(view -> {

            if (dark_mode.isChecked()) {
                //when checked
                background.setBackgroundResource(R.color.dark);
            }
                else
                {
                    //unchecked
                    background.setBackgroundResource(R.color.day);
            }
        });

        //Button click listener
        buttone.setOnClickListener(v -> {


            //data from Edit texts
            String simplestDiHours = diHours.getText().toString();
            String simplestDiMinutes = diMinutes.getText().toString();


            if (TextUtils.isEmpty(diHours.getText().toString()))
            {
                diHours.setError("Please enter the Hours you Ran");
            }

            else if (TextUtils.isEmpty(diMinutes.getText().toString())) {
                diMinutes.setError("Please enter the Minutes you Ran");
            }



            else
            {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("simplestDiMinutes", simplestDiMinutes);
                i.putExtra("simplestDiHours", simplestDiHours);
                startActivity(i);
                finish();
            }
        });
    }
}
