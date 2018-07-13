package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

public class CustomDialog extends Dialog {


    public interface ICustomDialogEventListener {
        public void onYesClicked();
        public void onNoClicked();
        public void onExitClicked();
        //abstract void onCancelClicked();
    }

    private Button okBtn;
    private Button cancelBtn;
    private RadioGroup radioG;
    private int checkedID;

    private ICustomDialogEventListener listener;

    public CustomDialog(@NonNull Context context, final ICustomDialogEventListener listener) {
        super(context,R.style.dialog);
        this.listener = listener;
        setContentView(R.layout.dialog_custom);
        okBtn = findViewById(R.id.dialog_custom_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedID == R.id.q4_yes_radio) {
                    listener.onYesClicked();
                    cancel();
                } else if (checkedID == R.id.q4_no_radio) {
                    listener.onNoClicked();
                    cancel();
                } else if (checkedID == R.id.q4_exit_radio) {
                    listener.onExitClicked();
                    cancel();
                } else {
                    Toast.makeText(getContext(), "Select a Radio Button", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelBtn = findViewById(R.id.dialog_custom_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        radioG = findViewById(R.id.q4_radio_group);
        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
            }
        });

    }

}
