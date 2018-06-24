package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    public void shortToast (String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    public void longToast (String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void goToActivity(Class c) {
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }

}
