package com.example.labcalc;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;

public class DigitWatcher implements TextWatcher {
    private EditText editText;
    private LayoutIdListener listener;

    public DigitWatcher(EditText editText, LayoutIdListener listener) {
        this.editText = editText;
        this.listener = listener;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        ViewParent viewParent = editText.getParent();
        if(viewParent instanceof View) {
            View parent = (View) viewParent;
            int parentId = parent.getId();
            listener.onTextChangedInLayout(parentId);
        }
    }

    public interface LayoutIdListener{
        void onTextChangedInLayout(int id);
    }
}
