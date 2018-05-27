package com.example.illya.lab2_dorogin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentOutput extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.input, container, false);


        return view;
    }

    public void setRezult(String rezult)
    {
        TextView view = (EditText) getView().findViewById(R.id.textViewRezult);
        view.setText(rezult);
    }

}
