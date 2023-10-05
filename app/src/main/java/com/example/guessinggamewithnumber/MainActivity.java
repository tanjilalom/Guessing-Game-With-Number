package com.example.guessinggamewithnumber;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.inputnum);
        result = findViewById(R.id.result);
        result.setText("");
        btn = findViewById(R.id.guessbutton);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String guessString = num.getText().toString();

        if (guessString.isEmpty())
        {
            errormassage();
        }
        else
        {
            int guess = Integer.parseInt(guessString);

            if (guess >= 51 || guess == 0)
            {
                num.setError("Number range is 1-50");
            }
            else
            {
                //Generating a random number
                Random random = new Random();
                int randomnum = random.nextInt(50) + 1;

                if (randomnum == guess) {
                    result.setText("Congratulation !! You have won");

                } else {
                    result.setText("Sorry ! You have lost. Guess again");
                }
            }
        }
    }

    void errormassage()
    {
        result.setText("Please Input a valid number");
        result.requestFocus();
        return;
    }

}