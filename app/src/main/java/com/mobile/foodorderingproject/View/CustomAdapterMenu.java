package com.mobile.foodorderingproject.View;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapterMenu extends ArrayAdapter {

    public CustomAdapterMenu(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}
