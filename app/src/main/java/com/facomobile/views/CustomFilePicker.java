package com.facomobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.facomobile.R;

import java.io.File;

public class CustomFilePicker extends LinearLayout {

    private File mPickedFile;

    private LinearLayout mRoot;
    private TextView mTvPicker;
    private Button mBtnPreview;

    public CustomFilePicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View mFilePicker = inflater.inflate(R.layout.custom_file_picker_view, this, true);
            mRoot = mFilePicker.findViewById(R.id.ll_file_picker_root);
            mTvPicker = mFilePicker.findViewById(R.id.tv_file_picker);
            mBtnPreview = mFilePicker.findViewById(R.id.btn_file_picker_preview);

            mTvPicker.setOnClickListener(view -> launchFilePicker());

//            mRoot.setOnClickListener(view -> Toast.makeText(context, "Hey heyyyyy", Toast.LENGTH_SHORT).show());
        }
    }

    public CustomFilePicker(Context context) {
        this(context, null);
    }

    private void launchFilePicker() {

    }


}
