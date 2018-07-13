package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.dialog.CustomDialog;

public class Q4Activity extends BaseActivity {

    private Button dBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        dBtn = findViewById(R.id.q4_dialog_btn);
        dBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog cd1 = new CustomDialog(Q4Activity.this, new CustomDialog.ICustomDialogEventListener() {
                    @Override
                    public void onExitClicked() {
                        Intent intent = new Intent();
                        intent.putExtra("Data","Exit");
                        setResult(200, intent);
                        Q4Activity.super.onBackPressed();
                    }
                    @Override
                    public void onYesClicked() {
                        shortToast("Yes");
                    }
                    @Override
                    public void onNoClicked() {
                        shortToast("No");
                    }
                });
                cd1.show();
            }
        });
    }

}
