package com.example.s43385508;
/*Student Number: 43385508
* Name: Ishmael Lehlohonolo Mafole
* Purpose: a_marathon_app_that_allows_you_to_insert_your_time_for
*          scores_enter_the_time_you_ran_below_then_press_submit.
* The Application is developed in accordance to the specifications of ICT2612
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.google.android.material.button.MaterialButton;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
  EditText diHours, diMinutes;
  //SwitchCompat dark_mode;
  RelativeLayout background;
    private SwitchCompat dark_mode;
    @SuppressLint("SetTextI18n")

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//locating dark mode switch via its ID
    dark_mode = findViewById(R.id.theme);

    //Using shared Preferences to store previous states
        SharedPreferences sharedPreferences = getSharedPreferences(
                "sharedPrefs", MODE_PRIVATE
        );
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final boolean  isDarkModeOn = sharedPreferences.getBoolean(
                "isDarkModeOn", false
        );
        //user reopens app
        if (isDarkModeOn){
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
            );
            dark_mode.setText("Enable Light Mode");
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
            dark_mode.setText("Switch to Dark Mode");
        }
//On clicking the button dark mode is activated or deactivated
    dark_mode.setOnClickListener(
            view -> {
                if (isDarkModeOn) {
                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_NO
                    );
                    editor.putBoolean(
                            "isDarkModeOn", false
                    );
                    editor.apply();
                } else {
                    //if dark mode is off
                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_YES
                    );
                    editor.putBoolean(
                            "isDarkModeOn", true
                    );
                    editor.apply();
                }

            }
    );



        //EditText location via ID
        diHours = findViewById(R.id.hours);
        diMinutes = findViewById(R.id.minutes);
        //Toggle Button location via ID
        dark_mode = findViewById(R.id.theme);
        //BackgroundColor for Theme location via ID
        background = findViewById(R.id.layout);

        //Button location via ID
        MaterialButton buttone = findViewById(R.id.button);

        //Fullscreen mode activated by default after setting Android Manifest file to transparent.
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //Submit Button on-click listener using Lambda to minimize clutter
        //Button click listener
        buttone.setOnClickListener(v -> {

            //data from Edit texts
            String simplestDiHours = diHours.getText().toString();
            String simplestDiMinutes = diMinutes.getText().toString();
    // using isEmpty and setError to validate input fields
            if (TextUtils.isEmpty(diHours.getText().toString()))
            {
                diHours.setError("Please enter the Hours you Ran");
            }
            else if( Integer.parseInt(diHours.getText().toString()) > 10 )
            {
                diHours.setError("Max hrs is 10");
            }
            else if (TextUtils.isEmpty(diMinutes.getText().toString())) {
                diMinutes.setError("Please enter the Minutes you Ran");
            }
            else if( Integer.parseInt(diMinutes.getText().toString()) > 59)
            {
                diMinutes.setError("Max is 59");
            }
            else if (Integer.parseInt(diMinutes.getText().toString()) == 0 && Integer.parseInt(diHours.getText().toString()) == 0  )
            {
                diMinutes.setError("You did not run");
            }
            else
            {
                //I used intents to pass the MainActivity data to MainActivity2
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("simplestDiMinutes", simplestDiMinutes);
                i.putExtra("simplestDiHours", simplestDiHours);
                startActivity(i);
                finish();
            }
        }
        );
    }
}

