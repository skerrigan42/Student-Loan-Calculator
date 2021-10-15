package com.example.studentloancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button mCalculateButton;
    private TextView mText1;
    private TextView mText2;
    private TextView mText3;
    private TextView mText4;
    private EditText mEdit1;
    private EditText mEdit2;
    private EditText mEdit3;
    private EditText mEdit4;
    private EditText mEdit5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        mEdit1 = (EditText) findViewById(R.id.EditText_loan_amount);

        mEdit2 = (EditText) findViewById(R.id.EditText_interest_rate);

        mEdit3 = (EditText) findViewById(R.id.EditText_loan_term);

        mEdit4 = (EditText) findViewById(R.id.EditText_loan_fees);

        mEdit5 = (EditText) findViewById(R.id.EditText_minimum_payment);

        mText1 = (TextView) findViewById(R.id.TextView_calculate1);
        mText2 = (TextView) findViewById(R.id.TextView_calculate2);
        mText3 = (TextView) findViewById(R.id.TextView_monthly_payment);
        mText4 = (TextView) findViewById(R.id.TextView_total_interest);

        mCalculateButton = (Button) findViewById(R.id.calculate_button);
        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mEdit1d = Double.parseDouble(mEdit1.getText().toString());
                double mEdit2d = Double.parseDouble(mEdit2.getText().toString());
                double mEdit3d = Double.parseDouble(mEdit3.getText().toString());
                double mEdit4d = Double.parseDouble(mEdit4.getText().toString());
                double mEdit5d = Double.parseDouble(mEdit5.getText().toString());
                double daily_interest = mEdit2d/100.0;
                double total_interest = ((mEdit1d+mEdit4d)*Math.pow(1+daily_interest,mEdit2d))-(mEdit1d+mEdit4d);
                double monthly_payment = ((mEdit1d+mEdit4d)*Math.pow(1+daily_interest,mEdit2d))/(mEdit3d*12);
                mText3.setText(Double.toString(monthly_payment));
                mText4.setText(Double.toString(total_interest));
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}