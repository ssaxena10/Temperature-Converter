package com.example.sharul.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class TemperatureConversion extends AppCompatActivity {

    private EditText temp;
    private RadioButton FtoC;
    private RadioButton CtoF;
    private EditText out;
    private TextView history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_conversion);

        temp = (EditText)findViewById(R.id.EnterTemp);
        FtoC = (RadioButton)findViewById(R.id.FtoC);
        CtoF = (RadioButton)findViewById(R.id.CtoF);
        out = (EditText)findViewById(R.id.ConvertedTemp);
        history = (TextView)findViewById(R.id.History);
        history.setMovementMethod(new ScrollingMovementMethod());
    }

    public void converter(View v)
    {

        double value = new Double(temp.getText().toString());
        if(FtoC.isChecked())
        {
            value = ((value-32.0)*(5.0/9.0));
        }
        else if(CtoF.isChecked())
        {
            value = ((value * (9.0 / 5.0)) + 32.0);
        }

        out.setText(String.format("%.1f",value));

        String convertedtext =  out.getText().toString();
        String enteredtext = temp.getText().toString();
        String historyText = history.getText().toString();


        if(FtoC.isChecked())
        {
            history.setText("F to C : " + enteredtext + "  ->  " + convertedtext + "\n" + historyText);
        }
        else if(CtoF.isChecked())
        {
            history.setText("C to F : " + enteredtext + "  ->  " + convertedtext + "\n" + historyText);
        }

        out.setText(String.format("%.1f",value));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("HISTORY", history.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        history.setText(savedInstanceState.getString("HISTORY"));
    }
}
