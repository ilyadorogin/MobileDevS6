package com.example.illya.lab2_dorogin;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragmentInput.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonRezult);
        button.setOnClickListener(v->{
            ((FragmentOutput) getFragmentManager().findFragmentByTag("output")).setRezult(((FragmentInput) getFragmentManager().findFragmentByTag("input")).getRezult());
        });
    }



    @Override
    public void onFragmentInteraction(String link) {
        FragmentOutput fragmentOutput = (FragmentOutput) getFragmentManager().findFragmentById(R.id.outputF);
        if (fragmentOutput != null && fragmentOutput.isInLayout())
            fragmentOutput.setRezult(link);
    }
}
