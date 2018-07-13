package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.app.ProgressDialog;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.BaseActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.dialog.CustomDialog;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.util.UtilLog;

import java.util.ArrayList;

public class DialogActivity extends BaseActivity {

    private RadioGroup rdg;
    private Button ok;
    private int checkedID;

    private final int DIALOG = 12345;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == DIALOG) {
                Bundle bundle = msg.getData();
                String s = bundle.getString("msg");
                shortToast("Dialog Message: " + s);
            }
            mHandler.handleMessage(msg);
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        rdg = findViewById(R.id.activity_dialog_rdg);
        ok = findViewById(R.id.activity_dialog_ok);

        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                shortToast("You chose " + checkedId);
                checkedID = checkedId;
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (checkedID == R.id.activity_dialog_rb1) {
                        //shortToast("You chose #1");
                        normalDialog();
                    } else if (checkedID == R.id.activity_dialog_rb2) {
                        //shortToast("You chose #2");
                        listDialog();
                    } else if (checkedID == R.id.activity_dialog_rb3) {
                        //shortToast("You chose #3");
                        singleChoiceDialog();
                    } else if (checkedID == R.id.activity_dialog_rb4) {
                        //shortToast("You chose #4");
                        multiChoiceDialog();
                    } else if (checkedID == R.id.activity_dialog_rb5) {
                        //shortToast("You chose #5");
                        waitingDialog();
                    } else if (checkedID == R.id.activity_dialog_rb6) {
                        //shortToast("You chose #6");
                        progressDialog();
                    } else if (checkedID == R.id.activity_dialog_rb7) {
                        //shortToast("You chose #7");
                        inputDialog();
                    } else if (checkedID == R.id.activity_dialog_rb8) {
                        //shortToast("You chose #8");
                        CustomDialog cd1 = new CustomDialog( DialogActivity.this, new CustomDialog.ICustomDialogEventListener() {
                            @Override
                            public void onYesClicked() {
                                shortToast("Yes");
                            }
                            @Override
                            public void onExitClicked() {
                                shortToast("Exit");
                            }
                            @Override
                            public void onNoClicked() {
                                shortToast("No");
                            }
                        });
                        cd1.show();
                    } else {
                        shortToast("Couldn't identify this RadioButton");
                    }
            }
        });
    }

    private void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Neutral");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked No");
            }
        });
        builder.show();
    }

    private void listDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: " + items[which]);
            }
        });
        builder.show();
    }

    int choice = 2;
    private void singleChoiceDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a Single Choice Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: " + choice);
            }
        });
        builder.show();
    }

    private void multiChoiceDialog() {
        final ArrayList<Integer> choices = new ArrayList<>();
        final String[] items = {"item1", "item2", "item3", "item4"};
        final boolean initChoiceSets[] = {false,true,false,false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a multi-choice dialog");
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    choices.add(which);
                } else {
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str = "";
                for (int i=0; i<size; i++) {
                    str += items[choices.get(i)] + " ";
                }
                shortToast("You chose " + str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                shortToast("Cancel was clicked");
            }
        });
        builder.show();
    }

    private void waitingDialog() {
        ProgressDialog waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                shortToast("Dialog was canceled!");
            }
        });
    }

    private void progressDialog() {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread() {
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (Exception e) {
                        UtilLog.d("progressDialog","Thread Error");
                        e.printStackTrace();
                    }
                }

                Bundle bundle = new Bundle();
                bundle.putString("msg","Download Success");
                Message msg = Message.obtain();
                msg.what = DIALOG;
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                progressDialog.cancel();

            }
        }.start();
    }

    private void inputDialog() {
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
        inputDialog.setTitle("I'm an input dialog");
        inputDialog.setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("Cancel", null).show();
    }

}//end DialogActivity class