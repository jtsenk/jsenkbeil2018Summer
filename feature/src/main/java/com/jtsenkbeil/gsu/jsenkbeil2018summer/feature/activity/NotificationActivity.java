package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

public class NotificationActivity extends AppCompatActivity {

    private Button smallN;
    private Button bigN;
    private Button picN;
    private NotificationManager nManager;
    private int notifyID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        smallN = findViewById(R.id.activity_notification_small);
        bigN = findViewById(R.id.activity_notification_big);
        picN = findViewById(R.id.activity_notification_pic);
        nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        smallN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "smallNotification", Toast.LENGTH_SHORT).show();
                NotificationChannel nChannel = new NotificationChannel("chan","chan",NotificationManager.IMPORTANCE_LOW);
                nManager.createNotificationChannel(nChannel);
                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getBaseContext(), "chan")
                    .setContentTitle("Small Notification Title")
                    .setContentText("Small Notification Text")
                    .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                    .setNumber(10)
                    .setTicker("Ticker")
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    .setOngoing(false)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setSmallIcon(R.mipmap.ic_launcher);
                nManager.notify(notifyID, nBuilder.build());
            }
        });

        bigN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "bigNotification", Toast.LENGTH_SHORT).show();
                NotificationChannel nChannel = new NotificationChannel("chan","chan",NotificationManager.IMPORTANCE_LOW);
                nManager.createNotificationChannel(nChannel);
                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getBaseContext(), "chan")
                        .setContentTitle("Big Notification Title")
                        .setContentText("Big Notification Text")
                        .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                        .setNumber(10)
                        .setTicker("Ticker")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setOngoing(false)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setSmallIcon(R.mipmap.ic_launcher);
                NotificationCompat.InboxStyle iStyle = new NotificationCompat.InboxStyle();
                iStyle.setBigContentTitle("Big Notification Title");
                for (int i=1; i<6; i++) {
                    iStyle.addLine("Line " + i);
                }
                iStyle.setBuilder(nBuilder);
                nBuilder.setStyle(iStyle);
                nManager.notify(notifyID, nBuilder.build());
            }
        });

        picN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "picNotification", Toast.LENGTH_SHORT).show();
                NotificationChannel nChannel = new NotificationChannel("chan","chan",NotificationManager.IMPORTANCE_LOW);
                nManager.createNotificationChannel(nChannel);
                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getBaseContext(), "chan")
                        .setContentTitle("BigPicture Notification Title")
                        .setContentText("BigPicture Notification Text")
                        .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                        .setNumber(10)
                        .setTicker("Ticker")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setOngoing(false)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setSmallIcon(R.mipmap.ic_launcher);
                NotificationCompat.BigPictureStyle pStyle = new NotificationCompat.BigPictureStyle();
                pStyle.setBigContentTitle("BigPicture Notification Title");
                pStyle.setSummaryText("BigPicture Summary Text");
                Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.mipmap.pic1);
                pStyle.bigPicture(bm1);
                pStyle.setBuilder(nBuilder);
                nBuilder.setStyle(pStyle);
                nManager.notify(notifyID, nBuilder.build());
            }
        });

    }

    private PendingIntent getDefaultIntent(int flags) {
        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(),1,new Intent(), flags);
        return pendingIntent;
    }
}
