package com.example.amrez.javaquizapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int trueAnswer, submitCount;
    private CheckBox cb_question2Choice1;
    private CheckBox cb_question2Choice2;
    private CheckBox cb_question2Choice3;
    private EditText et_question3Answer;
    private EditText et_question5Answer;
    private RadioButton rb_question1Choice2;
    private RadioButton rb_question4Choice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //question 1
        rb_question1Choice2 = (RadioButton) findViewById(R.id.rb_question1Choice2);
        //question 2
        cb_question2Choice1 = (CheckBox) findViewById(R.id.cb_question2Choice1);
        cb_question2Choice3 = (CheckBox) findViewById(R.id.cb_question2Choice3);
        cb_question2Choice2 = (CheckBox) findViewById(R.id.cb_question2Choice2);
        //question 3
        et_question3Answer = (EditText) findViewById(R.id.et_question3Answer);
        //question 4
        rb_question4Choice2 = (RadioButton) findViewById(R.id.rb_question4Choice2);
        //question 5
        et_question5Answer = (EditText) findViewById(R.id.et_question5Answer);
    }

    //get Result
    public void submit(View view) {
        submitCount += 1;
        if (submitCount > 1) {
            //to disable button and stop rotation
            Button submit = (Button) findViewById(R.id.submit);
            submit.setClickable(false);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            //quetion 1
            if (rb_question1Choice2.isChecked()) {
                trueAnswer += 1;
            }
            //get question 2 true answer
            if (cb_question2Choice1.isChecked() && cb_question2Choice3.isChecked() && !cb_question2Choice2.isChecked()) {
                trueAnswer += 1;
            }
            //get question 3 true answer
            if (et_question3Answer.getText().toString().equals("Null")) {
                trueAnswer += 1;
            }
            //get question 4 true answer
            if (rb_question4Choice2.isChecked()) {
                trueAnswer += 1;
            }
            //get question 5 true answer
            if (et_question5Answer.getText().toString().equals("16.4")) {
                trueAnswer += 1;
            }
            //display true and rong answer
            Toast.makeText(this, "true answer :" + String.valueOf(trueAnswer), Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Rong answer :" + String.valueOf(5 - trueAnswer), Toast.LENGTH_LONG).show();
        }

    }

    //true answer for all question
    public void trueAnswer(View view) {
        //Toast
        Toast.makeText(this, "1 => -32768 to 32767" + "\n" + "2 => integers and floating point numbers" + "\n" + "3 =>  Null" + "\n" + "4 => double" + "\n" + "5 =>16.4", Toast.LENGTH_LONG).show();
        //question 1
        rb_question1Choice2.setChecked(true);
        //question 2
        cb_question2Choice1.setChecked(true);
        cb_question2Choice3.setChecked(true);
        //question 3
        et_question3Answer.setText("Null");
        //question 4
        rb_question4Choice2.setChecked(true);
        //question 5
        et_question5Answer.setText("16.4");

    }
}
