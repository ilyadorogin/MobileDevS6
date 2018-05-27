package com.example.illya.lab2_dorogin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FragmentInput extends Fragment {

    OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.input, container, false);

        try {

            mListener = (OnFragmentInteractionListener) view.getContext();
        } catch (ClassCastException e) {
            throw new ClassCastException(view.getContext().toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }

        left = view.findViewById(R.id.textView);
        right = view.findViewById(R.id.textView2);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButtonPlus = view.findViewById(R.id.radioButtonPlus);
        radioButtonMinus = view.findViewById(R.id.radioButtonMinus);
        radioButtonMultiplication = view.findViewById(R.id.radioButtonMultiplication);
        radioButtonDivision = view.findViewById(R.id.radioButtonDivision);

        return view;
    }
    EditText left;
    EditText right;
    RadioGroup radioGroup;
    RadioButton radioButtonPlus;
    RadioButton radioButtonMinus;
    RadioButton radioButtonMultiplication;
    RadioButton radioButtonDivision;

    public String getRezult(){

        if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonPlus)
        {
            return  Double.valueOf(left.getText().toString())+Double.valueOf(right.getText().toString())+"";
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonMinus)
        {
            return Double.valueOf(left.getText().toString())-Double.valueOf(right.getText().toString())+"";
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonMultiplication)
        {
            return Double.valueOf(left.getText().toString())*Double.valueOf(right.getText().toString())+"";
        }
        else
        {
           return Double.valueOf(left.getText().toString())/Double.valueOf(right.getText().toString())+"";
        }



    }



    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String link);
    }
}
