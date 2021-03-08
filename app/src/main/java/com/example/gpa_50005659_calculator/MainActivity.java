package com.example.gpa_50005659_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//android:screenOrientation ="sensor" included in manifest file to allow for rotation between portrainand landscape

    EditText a, b, c, d, e;     //courses and data
    Button btn; //Button
    TextView gradeScore;    //gpa handle
    int score = 0; //initializing score grade counter

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (EditText) findViewById(R.id.al);    //al for Algorithms
        b = (EditText) findViewById(R.id.ds);    //al for Data Science
        c = (EditText) findViewById(R.id.ml);    //al for machine learning
        d = (EditText) findViewById(R.id.os);    //os for OS
        e = (EditText) findViewById(R.id.net);    //networking for Software Engineering

        btn = (Button) findViewById(R.id.b1);
        gradeScore = (TextView) findViewById(R.id.gpaScore);
        gradeScore.setBackgroundColor(Color.WHITE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aA, bB, cC, dD, eE;
                if (score % 2 == 0) {
                    if (a.getText().toString().equals("") || b.getText().toString().equals("") || c.getText().toString().equals("") || d.getText().toString().equals("") || d.getText().toString().equals("")) {
                        gradeScore.setText("Please Fill In All Required fields");

                    } else {
                        aA = Double.parseDouble(a.getText().toString());
                        bB = Double.parseDouble(b.getText().toString());
                        cC = Double.parseDouble(c.getText().toString());
                        dD = Double.parseDouble(d.getText().toString());
                        eE = Double.parseDouble(e.getText().toString());
                        double gradeAverage = (aA + bB + cC + dD + eE) / 5;
                        if (score >= 80 && score <= 100) {
                            gradeScore.setText(Double.toString(gradeAverage));
                            gradeScore.setBackgroundColor(Color.GREEN);
                        } else if (gradeAverage < 60) {
                            gradeScore.setText(Double.toString(gradeAverage));
                            gradeScore.setBackgroundColor(Color.YELLOW);
                        } else if (gradeAverage >= 61 && score <= 79) {
                            gradeScore.setText(Double.toString(gradeAverage));
                            gradeScore.setBackgroundColor(Color.RED);
                        }

                        score = score + 1;
                        btn.setText("Reset");
                    }
                } else {
                    a.setText("");
                    b.setText("");
                    c.setText("");
                    d.setText("");
                    e.setText("");
                    gradeScore.setText("");

                    btn.setText("Compute GPA");
                    gradeScore.setBackgroundColor(Color.WHITE);
                    score++;
                }
            }
        });
    }
}





