package com.example.illya.lab1.feature;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    EditText left;
    EditText right;
    TextView result;
    RadioGroup group;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        left = findViewById(R.id.textView);
        right = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);

        group=findViewById(R.id.radioGroup);

        button = findViewById(R.id.buttonRezult);

        button.setOnClickListener(v->{
            if (group.getCheckedRadioButtonId() == R.id.radioButtonPlus)
            {
                result.setText(Double.valueOf(left.getText().toString())+Double.valueOf(right.getText().toString())+"");
            }
            else if (group.getCheckedRadioButtonId() == R.id.radioButtonMinus)
            {
                result.setText(Double.valueOf(left.getText().toString())-Double.valueOf(right.getText().toString())+"");
            }
            else if (group.getCheckedRadioButtonId() == R.id.radioButtonMultiplication)
            {
                result.setText(Double.valueOf(left.getText().toString())*Double.valueOf(right.getText().toString())+"");
            }
            else if (group.getCheckedRadioButtonId() == R.id.radioButtonDivision)
            {
                result.setText(Double.valueOf(left.getText().toString())/Double.valueOf(right.getText().toString())+"");
            }

        });



    }
}
