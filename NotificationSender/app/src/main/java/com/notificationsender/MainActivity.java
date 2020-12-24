package com.notificationsender;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView head;
    EditText TitleMessage,message;
    Button channelBtn1,channelBtn2;
    NotificationManagerCompat notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        head = findViewById(R.id.heading);
        TitleMessage = findViewById(R.id.titlemessage);
        message = findViewById(R.id.message);
        channelBtn1 = findViewById(R.id.button);
        channelBtn2 = findViewById(R.id.button2);
        notify = NotificationManagerCompat.from(this);

        channelBtn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                create1(v);
            }
        });
        channelBtn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                create2(v);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void create1(View view){
        String title =TitleMessage.getText().toString();
        String Message = message.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,App.Channel_Id_1).setSmallIcon(R.drawable.ic_baseline_gps_fixed_24).setContentTitle(title).setContentText(Message).setPriority(Notification.PRIORITY_HIGH).setCategory(Notification.CATEGORY_MESSAGE).build();
        notify.notify(1,notification);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void create2(View v) {
        String title =TitleMessage.getText().toString();
        String Message = message.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,App.Channel_Id_1).setSmallIcon(R.drawable.ic_baseline_gps_fixed_24).setContentTitle(title).setContentText(Message).setPriority(Notification.PRIORITY_LOW).setCategory(Notification.CATEGORY_MESSAGE).build();
        notify.notify(2,notification);
    }
}