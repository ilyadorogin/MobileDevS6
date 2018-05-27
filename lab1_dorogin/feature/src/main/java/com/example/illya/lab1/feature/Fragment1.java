package com.example.illya.lab1.feature;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_1_layout, container);
//        Button button = rootView.findViewById(R.id.button);
//        button.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "ti pidor", Toast.LENGTH_LONG);
//        });

        return rootView;
    }
}
