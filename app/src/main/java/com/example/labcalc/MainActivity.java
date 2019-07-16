package com.example.labcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.labcalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        bindPickers();
        binding.btnCalculate.setOnClickListener(this::calculate);
    }


    private void calculatePanel(int otherSidePanel) {
        if(otherSidePanel == binding.cmykLayout.getId()){
            //TODO cmyk calculation
        } else if (otherSidePanel == binding.labLayout.getId()){
            //TODO lab calculation
        }
    }

    private void bindPickers() {
        setupInput(binding.cValue.input, binding.cValue.increment, binding.cValue.decrement);
        setupInput(binding.mValue.input, binding.mValue.increment, binding.mValue.decrement);
        setupInput(binding.yValue.input, binding.yValue.increment, binding.yValue.decrement);
        setupInput(binding.kValue.input, binding.kValue.increment, binding.kValue.decrement);
        setupInput(binding.lValue.input, binding.lValue.increment, binding.lValue.decrement);
        setupInput(binding.aValue.input, binding.aValue.increment, binding.aValue.decrement);
        setupInput(binding.bValue.input, binding.bValue.increment, binding.bValue.decrement);
    }

    private void setupInput(final EditText editText, ImageView btnIncrement, ImageView btnDecrement){
        btnIncrement.setOnClickListener(v -> editText.setText(String.valueOf(parseInt(editText) + 1)));
        btnDecrement.setOnClickListener(v -> editText.setText(String.valueOf(parseInt(editText) - 1)));
        editText.addTextChangedListener(new DigitWatcher(editText, this::calculatePanel));
    }

    private int parseInt(TextView textView){
        CharSequence text = textView.getText();
        if(TextUtils.isDigitsOnly(text)){
           return Integer.parseInt(text.toString());
        } else return 0;
    }


    private void calculate(View view) {

        binding.imgCmyk.setImageDrawable(new ColorDrawable(Color.rgb(0,0,10)));

    }
}
