package com.example.illya.lab3_dorogin;

import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    EditText num1;
    EditText num2;
    Button btnOpen;
    String str;


    private static  final String filename = "datafile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);




        btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open();
            }
        });






        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                num1 = findViewById(R.id.edit_text_number1);
                num2 = findViewById(R.id.edit_text_number2);

                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());
                Float f1 = Float.parseFloat(num1.getText().toString());
                Float f2 = Float.parseFloat(num2.getText().toString());


                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                //textView.setText("Your choice: " + radioButton.getText());

                String btn = radioButton.getText().toString();
                if(btn.equals("Add"))
                {
                    textView.setText(String.valueOf(n1+n2));
                    str = String.valueOf(n1) + " + " + String.valueOf(n2) + " = " + String.valueOf(n1+n2);
                }
                else if(btn.equals("Subtract")) {
                    textView.setText(String.valueOf(n1 - n2));
                    str = String.valueOf(n1) + " - " + String.valueOf(n2) + " = " + String.valueOf(n1-n2);
                }
                else if(btn.equals("Multiply")) {
                    textView.setText(String.valueOf(n1 * n2));
                    str = String.valueOf(n1) + " * " + String.valueOf(n2) + " = " + String.valueOf(n1*n2);
                }
                else {
                    textView.setText(String.valueOf(f1 / f2));
                    str = String.valueOf(n1) + " / " + String.valueOf(n2) + " = " + String.valueOf(f1/f2);
                }
                str = str+'\n';
                Save();

            }
        });
    }


    //Method for openeing new Activity
    public void Open()
    {
        Intent intent = new Intent(this,Output.class);
        startActivity(intent);
    }

    //Methond for saving the file
    public void Save() {
        String txt = str;
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(filename, MODE_APPEND);
            try {
                fos.write(txt.getBytes());
                Toast.makeText(this,"Saved to " + getFilesDir() + "/" + filename,Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }}
        catch (FileNotFoundException e){e.printStackTrace();}
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void load() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            num1.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }
}