package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

public class CustomDialog extends Dialog {


    public interface ICustomDialogEventListener {
        public void onOKClicked(String msg);
        //abstract void onCancelClicked();
    }

    private Button okBtn;

    private ICustomDialogEventListener listener;

    public CustomDialog(@NonNull Context context, final ICustomDialogEventListener listener) {
        super(context,R.style.dialog);
        this.listener = listener;
        setContentView(R.layout.dialog_custom);
        okBtn = findViewById(R.id.dialog_custom_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOKClicked("You Clicked OK");
                cancel();
            }
        });

    }

}
